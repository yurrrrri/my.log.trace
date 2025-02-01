package io.myLogTrace.view;

import io.myLogTrace.view.sdo.FeelingStatsViewCdo;
import io.myLogTrace.domain.vo.Feeling;
import io.myLogTrace.view.vo.Strategy;
import lombok.*;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_TOO_SHORT;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class FeelingStatsView {
    //
    private String id;
    private Strategy strategy; // 통계 기준 (월별/분기별/연도별/날씨별)
    private String date; // 기간, YYYYMM
    private Feeling feeling;
    private int count;
    private Long registeredOn; // 등록일시

    public static FeelingStatsView create(FeelingStatsViewCdo cdo) {
        //
        if (cdo.getDate().length() < 6) {
            throw new IllegalArgumentException(LENGTH_TOO_SHORT.name());
        }

        return FeelingStatsView.builder()
                .strategy(cdo.getStrategy())
                .date(cdo.getDate())
                .feeling(cdo.getFeeling())
                .count(cdo.getCount())
                .build();
    }
}