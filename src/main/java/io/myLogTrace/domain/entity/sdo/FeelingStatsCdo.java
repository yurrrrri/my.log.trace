package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.Feeling;
import io.myLogTrace.domain.vo.Strategy;
import lombok.Getter;

@Getter
public class FeelingStatsCdo {
    //
    private Strategy strategy;
    private String date;
    private Feeling feeling;
    private int count;
}
