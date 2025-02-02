package io.myLogTrace.service;

import io.myLogTrace.command.ModifyAnniversary;
import io.myLogTrace.common.exception.DuplicateDataException;
import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.repository.AnniversaryRepository;
import io.myLogTrace.service.customstore.AnniversaryCustomStore;
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
public class AnniversariesService {
    //
    private final AnniversaryRepository anniversaryRepository;
    private final AnniversaryCustomStore anniversaryCustomStore;

    public Anniversary findAnniversary(String id) {
        //
        return this.getAnniversary(id);
    }

    public List<Anniversary> findAnniversaries(String date, ViewType type) {
        //
        return switch (type) {
            case DAILY -> anniversaryRepository.findByDate(date);
            case WEEKLY -> anniversaryCustomStore.findWeeklyAnniversaries(date);
            default -> anniversaryRepository.findByDateStartingWith(date.substring(0, 7));
        };
    }

    public String create(AnniversaryCdo cdo) {
        //
        if (anniversaryRepository.existsByDateAndName(cdo.getDate(), cdo.getName())) {
            throw new DuplicateDataException(DATA_ALREADY_EXISTS.name());
        }
        Anniversary entity = Anniversary.create(cdo);
        Anniversary anniversary = anniversaryRepository.save(entity);
        return anniversary.getId();
    }

    public String update(ModifyAnniversary command) {
        //
        Anniversary anniversary = this.getAnniversary(command.getId());
        BeanUtils.copyProperties(command, anniversary);
        anniversaryRepository.save(anniversary);
        return command.getId();
    }

    public void delete(String id) {
        // 물리 삭제
        anniversaryRepository.deleteById(id);
    }

    private Anniversary getAnniversary(String id) {
        //
        Optional<Anniversary> opt = anniversaryRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return opt.get();
    }
}
