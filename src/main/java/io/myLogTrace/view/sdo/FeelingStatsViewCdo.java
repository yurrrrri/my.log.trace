package io.myLogTrace.view.sdo;

import io.myLogTrace.domain.vo.Feeling;
import io.myLogTrace.view.vo.Strategy;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class FeelingStatsViewCdo {
    //
    private Strategy strategy;
    @Size(max = 10)
    private String date;
    private Feeling feeling;
    private int count;
}
