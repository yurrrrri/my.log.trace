package io.myLogTrace.view.repository;

import io.myLogTrace.view.TodoStatsView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoStatsViewRepository extends JpaRepository<TodoStatsView, String> {
}
