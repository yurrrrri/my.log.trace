package io.myLogTrace.view.repository.jpa;

import io.myLogTrace.domain.vo.Status;
import io.myLogTrace.view.vo.Strategy;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "TodoStatusView")
@Table(name = "TODO_STATS_VIEW")
public class TodoStatsViewJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    private Strategy strategy; // 통계 기준 (월별/분기별/연도별)
    @Column(length = 6)
    private String date; // 기간, YYYYMM
    @Enumerated(EnumType.STRING)
    private Status status; // 상태(현황)
    private int count;
    @CreatedDate
    private Long registeredOn; // 등록일시
}