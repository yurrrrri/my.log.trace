package io.myLogTrace.service;

import io.myLogTrace.command.journal.ChangeJournalImage;
import io.myLogTrace.command.journal.ModifyJournal;
import io.myLogTrace.common.exception.DuplicateDataException;
import io.myLogTrace.domain.entity.Journal;
import io.myLogTrace.domain.entity.sdo.JournalCdo;
import io.myLogTrace.repository.JournalRepository;
import io.myLogTrace.repository.jpa.JournalJpo;
import io.myLogTrace.service.customstore.JournalCustomStore;
import io.myLogTrace.service.vo.ViewType;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_ALREADY_EXISTS;
import static io.myLogTrace.common.exception.LogExceptionCode.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class JournalService {
  //
  private final JournalRepository journalRepository;
  private final JournalCustomStore journalCustomStore;

  public List<Journal> findJournals(String date, ViewType type) {
    //
    return switch (type) {
      case DAILY -> journalCustomStore.findDailyJournals(date);
      case WEEKLY -> journalCustomStore.findWeeklyJournals(date);
      default -> journalCustomStore.findMonthlyJournals(date);
    };
  }

  public String create(JournalCdo cdo) {
    //
    if (journalRepository.existsByDate(cdo.getDate())) {
      throw new DuplicateDataException(DATA_ALREADY_EXISTS.name());
    }
    Journal entity = Journal.create(cdo);
    JournalJpo journalJpo = journalRepository.save(entity.toJpo());
    return journalJpo.getId();
  }

  public String update(ModifyJournal command) {
    //
    Journal journal = this.getJournal(command.getId());
    BeanUtils.copyProperties(command, journal);
    journalRepository.save(journal.toJpo());
    return command.getId();
  }

  public String update(ChangeJournalImage command) {
    //
    Journal journal = this.getJournal(command.getId());
    journal.changeImages(command.getImage1Id(), command.getImage2Id());
    journalRepository.save(journal.toJpo());
    return command.getId();
  }

  public String update(String id) {
    //
    Journal journal = this.getJournal(id);
    journal.changeLocked();
    journalRepository.save(journal.toJpo());
    return id;
  }

  public void delete(String id) {
    // 물리 삭제
    journalRepository.deleteById(id);
  }

  private Journal getJournal(String id) {
    //
    Optional<JournalJpo> opt = journalRepository.findById(id);
    if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
    return Journal.toDomain(opt.get());
  }
}
