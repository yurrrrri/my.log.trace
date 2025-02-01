package io.myLogTrace.flow.todo;

import io.myLogTrace.command.todo.ChangeTodoStatus;
import io.myLogTrace.command.todo.ModifyTodo;
import io.myLogTrace.domain.entity.sdo.TodoCdo;
import io.myLogTrace.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoFlow {
    //
    private final TodoService todoService;

    @PostMapping("")
    public String create(@Valid @RequestBody TodoCdo cdo) {
        //
        return todoService.create(cdo);
    }

    @PutMapping("")
    public String update(@Valid @RequestBody ModifyTodo command) {
        //
        return todoService.update(command);
    }

    @PatchMapping("")
    public String update(@Valid @RequestBody ChangeTodoStatus command) {
        //
        return todoService.update(command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        //
        todoService.delete(id);
    }
}
