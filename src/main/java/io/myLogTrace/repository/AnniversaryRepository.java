package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.AnniversaryJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnniversaryRepository extends JpaRepository<AnniversaryJpo, String> {
  //
  boolean existsByDateAndName(String date, String name);
}
