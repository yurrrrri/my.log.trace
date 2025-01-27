package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Anniversary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnniversaryRepository extends JpaRepository<Anniversary, String> {
}
