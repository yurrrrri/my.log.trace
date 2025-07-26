package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.CertificationJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<CertificationJpo, String> {
    //
}
