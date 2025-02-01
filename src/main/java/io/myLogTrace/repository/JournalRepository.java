package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, String> {
    //
    boolean existsByDate(String date);
    List<Journal> findByDate(String date);
    List<Journal> findByDateStartingWith(String monthDate);
}
