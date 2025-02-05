package io.myLogTrace.service.customstore;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.myLogTrace.domain.entity.Todo;
import io.myLogTrace.repository.jpa.TodoJpo;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static io.myLogTrace.repository.jpa.QTodoJpo.todoJpo;

@RequiredArgsConstructor
public class TodoCustomStore {
    //
    private final JPAQueryFactory queryFactory;

    public List<Todo> findWeeklyTodos(String date) {
        //
        LocalDate localDate = LocalDate.parse(date);
        LocalDate startDate = localDate.with(DayOfWeek.SUNDAY);
        LocalDate endDate = startDate.plusWeeks(1);

        JPAQuery<TodoJpo> jpaQuery = queryFactory
                .selectFrom(todoJpo)
                .where(new BooleanBuilder()
                        .andAnyOf(
                                todoJpo.startDateTime.goe(startDate.atStartOfDay()).and(todoJpo.startDateTime.lt(endDate.atStartOfDay())),
                                todoJpo.startDateTime.loe(startDate.atStartOfDay()).and(todoJpo.endDateTime.gt(startDate.atStartOfDay())),
                                todoJpo.endDateTime.goe(startDate.atStartOfDay()).and(todoJpo.endDateTime.lt(endDate.atStartOfDay()))))
                .orderBy(todoJpo.startDateTime.asc())
                .fetchAll();

        return TodoJpo.toDomains(jpaQuery);
    }
}
