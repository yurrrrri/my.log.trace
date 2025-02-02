package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, String> {
    //
    List<History> findAllOrderByStartDateTimeAsc();
}
