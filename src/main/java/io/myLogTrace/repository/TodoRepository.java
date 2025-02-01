package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, String> {
    //
    List<Todo> findByDate(String date);
    List<Todo> findByDateStartingWith(String date);
}
