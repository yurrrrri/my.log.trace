package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.entity.sdo.FeelingStatsCdo;
import io.myLogTrace.domain.vo.Feeling;
import io.myLogTrace.domain.vo.Strategy;
import lombok.*;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_TOO_SHORT;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class FeelingStats {
    //
    private String id;
    private Strategy strategy; // 통계 기준 (월별/분기별/연도별/날씨별)
    private String date; // 기간, YYYYMM
    private Feeling feeling;
    private int count;
    private Long registeredOn; // 등록일시

    public static FeelingStats create(FeelingStatsCdo cdo) {
        //
        if (cdo.getDate().length() < 6) throw LogException.of(LENGTH_TOO_SHORT);

        return FeelingStats.builder()
                .strategy(cdo.getStrategy())
                .date(cdo.getDate())
                .feeling(cdo.getFeeling())
                .count(cdo.getCount())
                .build();
    }
}