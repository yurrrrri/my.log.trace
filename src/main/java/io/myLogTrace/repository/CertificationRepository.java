package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, String> {
}
