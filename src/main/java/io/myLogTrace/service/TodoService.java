package io.myLogTrace.service;

import io.myLogTrace.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    //
    private final TodoRepository todoRepository;
}
