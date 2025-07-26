package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.JournalJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<JournalJpo, String> {
    //
    boolean existsByDate(String date);
}
