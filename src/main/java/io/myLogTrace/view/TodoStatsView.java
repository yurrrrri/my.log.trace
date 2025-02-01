package io.myLogTrace.view;

import io.myLogTrace.view.sdo.TodoStatsViewCdo;
import io.myLogTrace.domain.vo.Status;
import io.myLogTrace.view.vo.Strategy;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class TodoStatsView {
    //
    private String id;
    private Strategy strategy; // 통계 기준 (월별/분기별/연도별)
    private String date; // 기간, YYYYMM
    private Status status; // 상태(현황)
    private int count;
    private Long registeredOn; // 등록일시

    public static TodoStatsView create(TodoStatsViewCdo cdo) {
        //
        return TodoStatsView.builder()
                .strategy(cdo.getStrategy())
                .date(cdo.getDate())
                .status(cdo.getStatus())
                .count(cdo.getCount())
                .build();
    }
}