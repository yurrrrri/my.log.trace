package io.myLogTrace.domain.entity;

import io.myLogTrace.common.policy.DateTimePolicy;
import io.myLogTrace.domain.entity.sdo.TodoCdo;
import io.myLogTrace.domain.vo.Status;
import lombok.*;

import java.time.LocalDateTime;

import static io.myLogTrace.common.exception.LogExceptionCode.DATETIME_NOT_VALID;
import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
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

    public static Todo create(TodoCdo cdo) {
        //
        if (cdo.getContents().length() > 30 || cdo.getMemo().length() > 50)
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        if (!DateTimePolicy.isValid(cdo.getStartDateTime(), cdo.getEndDateTime()))
            throw new IllegalArgumentException(DATETIME_NOT_VALID.name());

        return Todo.builder()
                .categoryId(cdo.getCategoryId())
                .contents(cdo.getContents())
                .memo(cdo.getMemo())
                .isPeriod(cdo.getIsPeriod())
                .startDateTime(cdo.getStartDateTime())
                .endDateTime(cdo.getEndDateTime())
                .status(cdo.getStatus())
                .build();
    }
}
