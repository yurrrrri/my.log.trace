package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.vo.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Todo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String categoryId; // 카테고리 Id
    @Column(length = 60)
    private String contents; // 할 일
    @Column(length = 100)
    private String memo; // 메모
    private boolean isPeriod; // true: 기간, false: 특정일
    private LocalDateTime startDateTime; // 기간 시작일시
    private LocalDateTime endDateTime; // 기간 종료일시
    @Enumerated(EnumType.STRING)
    private Status status; // 상태
    @CreatedDate
    private Long registeredOn; // 등록일시

    public static Todo create(
            final String categoryId, final String contents, final String memo, final boolean isPeriod,
            final LocalDateTime startDateTime, final LocalDateTime endDateTime, final Status status) {
        //
        if (contents.length() > 30 || memo.length() > 50) throw LogException.of(LENGTH_OVER_ERROR);

        return Todo.builder()
                .categoryId(categoryId)
                .contents(contents)
                .memo(memo)
                .isPeriod(isPeriod)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .status(status)
                .build();
    }
}
