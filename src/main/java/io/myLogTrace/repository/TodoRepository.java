package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.TodoJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoJpo, String> {
    //
}
