package io.myLogTrace.service;

import io.myLogTrace.command.todo.ChangeTodoStatus;
import io.myLogTrace.command.todo.ModifyTodo;
import io.myLogTrace.domain.entity.Todo;
import io.myLogTrace.domain.entity.sdo.TodoCdo;
import io.myLogTrace.repository.TodoRepository;
import io.myLogTrace.service.customstore.TodoCustomStore;
import io.myLogTrace.service.vo.ViewType;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    //
    private final TodoRepository todoRepository;
    private final TodoCustomStore todoCustomStore;

    public List<Todo> findTodos(String date, ViewType type) {
        //
        return switch (type) {
            case DAILY -> todoRepository.findByDate(date);
            case WEEKLY -> todoCustomStore.findWeeklyTodos(date);
            default -> todoRepository.findByDateStartingWith(date);
        };
    }

    public String create(TodoCdo cdo) {
        //
        Todo entity = Todo.create(cdo);
        Todo todo = todoRepository.save(entity);
        return todo.getId();
    }

    public String update(ModifyTodo command) {
        //
        Todo todo = this.getTodo(command.getId());
        BeanUtils.copyProperties(command, todo);
        todoRepository.save(todo);
        return command.getId();
    }

    public String update(ChangeTodoStatus command) {
        //
        Todo todo = this.getTodo(command.getId());
        todo.ChangeStatus(command.getStatus());
        todoRepository.save(todo);
        return command.getId();
    }

    public void delete(String id) {
        //
        todoRepository.deleteById(id);
    }

    private Todo getTodo(String id) {
        //
        Optional<Todo> opt = todoRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return opt.get();
    }
}
