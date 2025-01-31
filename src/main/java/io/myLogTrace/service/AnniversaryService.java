package io.myLogTrace.service;

import io.myLogTrace.common.exception.DuplicateDataException;
import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.repository.AnniversaryRepository;
import io.myLogTrace.service.customstore.AnniversaryCustomStore;
import io.myLogTrace.service.sdo.AnniversaryUdo;
import io.myLogTrace.service.vo.AnniversarySearchType;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_ALREADY_EXISTS;
import static io.myLogTrace.common.exception.LogExceptionCode.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AnniversaryService {
    //
    private final AnniversaryRepository anniversaryRepository;
    private final AnniversaryCustomStore anniversaryCustomStore;

    public List<Anniversary> findAnniversaries(String date, AnniversarySearchType type) {
        //
        return switch (type) {
            case DAILY -> anniversaryRepository.findByDate(date);
            case WEEKLY -> anniversaryCustomStore.findByMonthlyAnniversaries(date);
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

    public String update(String id, AnniversaryUdo udo) {
        //
        Optional<Anniversary> opt = anniversaryRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());

        Anniversary anniversary = opt.get();
        BeanUtils.copyProperties(udo, anniversary);
        anniversaryRepository.save(anniversary);
        return id;
    }

    public void delete(String id) {
        // 물리 삭제
        anniversaryRepository.deleteById(id);
    }
}
