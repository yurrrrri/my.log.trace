package io.myLogTrace.repository.jpa;

import com.querydsl.jpa.impl.JPAQuery;
import io.myLogTrace.domain.entity.Todo;
import io.myLogTrace.domain.vo.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Todo")
@Table(name = "TODO")
public class TodoJpo {
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

    public static List<Todo> toDomains(JPAQuery<TodoJpo> jpos) {
        //
        return jpos.stream().map(Todo::toDomain).toList();
    }
}
