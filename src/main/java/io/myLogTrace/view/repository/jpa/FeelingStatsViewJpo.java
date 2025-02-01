package io.myLogTrace.view.repository.jpa;

import io.myLogTrace.domain.vo.Feeling;
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
@Entity(name = "FeelingStatsView")
@Table(name = "FEELING_STATS_VIEW")
public class FeelingStatsViewJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    private Strategy strategy; // 통계 기준 (월별/분기별/연도별/날씨별)
    @Column(length = 10)
    private String date; // 기간, YYYYMM
    @Enumerated(EnumType.STRING)
    private Feeling feeling;
    private int count;
    @CreatedDate
    private Long registeredOn; // 등록일시
}