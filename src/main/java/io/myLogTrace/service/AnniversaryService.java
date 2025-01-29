package io.myLogTrace.service;

import io.myLogTrace.common.exception.DuplicateDataException;
import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.repository.AnniversaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_ALREADY_EXISTS;

@Service
@RequiredArgsConstructor
public class AnniversaryService {
    //
    private final AnniversaryRepository anniversaryRepository;

    public String create(AnniversaryCdo cdo) {
        //
        if (anniversaryRepository.existsByDateAndName(cdo.getDate(), cdo.getName())) {
            throw new DuplicateDataException(DATA_ALREADY_EXISTS.name());
        }
        Anniversary entity = Anniversary.create(cdo);
        Anniversary anniversary = anniversaryRepository.save(entity);
        return anniversary.getId();
    }
}
