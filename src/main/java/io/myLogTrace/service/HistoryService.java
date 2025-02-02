package io.myLogTrace.service;

import io.myLogTrace.command.ModifyHistory;
import io.myLogTrace.domain.entity.History;
import io.myLogTrace.domain.entity.sdo.HistoryCdo;
import io.myLogTrace.repository.HistoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryService {
    //
    private final HistoryRepository historyRepository;

    public History findHistory(String id) {
        //
        return this.getHistory(id);
    }

    public List<History> findHistories() {
        //
        return historyRepository.findAllOrderByStartDateTimeAsc();
    }

    public String create(HistoryCdo cdo) {
        //
        History entity = History.create(cdo);
        History history = historyRepository.save(entity);
        return history.getId();
    }

    public String update(ModifyHistory command) {
        //
        History history = this.getHistory(command.getId());
        BeanUtils.copyProperties(command, history);
        historyRepository.save(history);
        return command.getId();
    }

    public void delete(String id) {
        //
        historyRepository.deleteById(id);
    }

    private History getHistory(String id) {
        //
        Optional<History> opt = historyRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return opt.get();
    }
}
