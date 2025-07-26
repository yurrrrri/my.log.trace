package io.myLogTrace.domain.entity;

import io.myLogTrace.common.policy.DateTimePolicy;
import io.myLogTrace.domain.entity.sdo.TodoCdo;
import io.myLogTrace.domain.vo.Status;
import io.myLogTrace.repository.jpa.TodoJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.List;

import static io.myLogTrace.common.exception.LogExceptionCode.DATETIME_NOT_VALID;
import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {
    //
    private String id;
    private String categoryId; // 카테고리 Id
    private String contents; // 할 일
    private String memo; // 메모
    private boolean isPeriod; // true: 기간, false: 특정일
    private LocalDateTime startDateTime; // 기간 시작일시
    private LocalDateTime endDateTime; // 기간 종료일시
    private Status status; // 상태
    private Long registeredOn; // 등록일시

    public void ChangeStatus(Status status) {
        this.status = status;
    }

    public static Todo create(TodoCdo cdo) {
        //
        if (cdo.getContents().length() > 30 || cdo.getMemo().length() > 50)
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        if (!DateTimePolicy.isValid(cdo.getStartDateTime(), cdo.getEndDateTime()))
            throw new IllegalArgumentException(DATETIME_NOT_VALID.name());

        Todo todo = new Todo();
        BeanUtils.copyProperties(cdo, todo);
        return todo;
    }

    public static Todo toDomain(TodoJpo jpo) {
        //
        Todo todo = new Todo();
        BeanUtils.copyProperties(jpo, todo);
        return todo;
    }

    public static List<Todo> toDomains(List<TodoJpo> jpos) {
        //
        return jpos.stream().map(Todo::toDomain).toList();
    }

    public TodoJpo toJpo() {
        //
        TodoJpo jpo = new TodoJpo();
        BeanUtils.copyProperties(this, jpo);
        return jpo;
    }
}
