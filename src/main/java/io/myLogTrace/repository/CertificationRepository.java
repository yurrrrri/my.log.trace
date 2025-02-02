package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, String> {
    //
    List<Certification> findAllOrderByRegisteredOnAsc();
}
