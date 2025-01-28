package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.TodoStatsCdo;
import io.myLogTrace.domain.vo.Status;
import io.myLogTrace.domain.vo.Strategy;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class TodoStats {
    //
    private String id;
    private Strategy strategy; // 통계 기준 (월별/분기별/연도별)
    private String date; // 기간, YYYYMM
    private Status status; // 상태(현황)
    private int count;
    private Long registeredOn; // 등록일시

    public static TodoStats create(TodoStatsCdo cdo) {
        //
        return TodoStats.builder()
                .strategy(cdo.getStrategy())
                .date(cdo.getDate())
                .status(cdo.getStatus())
                .count(cdo.getCount())
                .build();
    }
}