package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, String> {
}
