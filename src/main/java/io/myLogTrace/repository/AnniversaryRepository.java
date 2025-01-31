package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Anniversary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnniversaryRepository extends JpaRepository<Anniversary, String> {
    //
    boolean existsByDateAndName(String date, String name);
    List<Anniversary> findByDate(String date);
    List<Anniversary> findByDateStartingWith(String monthDate);
}
