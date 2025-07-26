package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.HistoryJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<HistoryJpo, String> {
    //
}
