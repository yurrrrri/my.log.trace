package io.myLogTrace.flow.todo;

import io.myLogTrace.domain.entity.Todo;
import io.myLogTrace.service.TodoService;
import io.myLogTrace.service.vo.ViewType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/todos")
@RestController
public class TodoSeek {
    //
    private final TodoService todoService;

    @PostMapping("/daily")
    public List<Todo> findDailyTodo(@RequestParam String date) {
        //
        return todoService.findTodos(date, ViewType.DAILY);
    }

    @PostMapping("/weekly")
    public List<Todo> findWeeklyTodo(@RequestParam String date) {
        //
        return todoService.findTodos(date, ViewType.WEEKLY);
    }

    @PostMapping("/monthly")
    public List<Todo> findMonthlyTodo(@RequestParam String date) {
        //
        return todoService.findTodos(date, ViewType.MONTHLY);
    }
}