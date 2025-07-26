package io.myLogTrace.service;

import io.myLogTrace.command.ModifyCertification;
import io.myLogTrace.domain.entity.Certification;
import io.myLogTrace.domain.entity.sdo.CertificationCdo;
import io.myLogTrace.repository.CertificationRepository;
import io.myLogTrace.repository.jpa.CertificationJpo;
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
public class CertificationService {
    //
    private final CertificationRepository certificationRepository;

    public Certification findCertification(String id) {
        //
        return this.getCertification(id);
    }

    public List<Certification> findCertifications() {
        //
        return Certification.toDomains(certificationRepository.findAll());
    }

    public String create(CertificationCdo cdo) {
        //
        Certification entity = Certification.create(cdo);
        CertificationJpo certificationJpo = certificationRepository.save(entity.toJpo());
        return certificationJpo.getId();
    }

    public String update(ModifyCertification command) {
        //
        Certification certification = this.getCertification(command.getId());
        BeanUtils.copyProperties(command, certification);
        certificationRepository.save(certification.toJpo());
        return command.getId();
    }

    public void delete(String id) {
        //
        certificationRepository.deleteById(id);
    }

    private Certification getCertification(String id) {
        //
        Optional<CertificationJpo> opt = certificationRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return Certification.toDomain(opt.get());
    }
}
