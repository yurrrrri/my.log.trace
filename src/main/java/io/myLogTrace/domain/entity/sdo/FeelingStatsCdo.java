package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.Feeling;
import io.myLogTrace.domain.vo.Strategy;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class FeelingStatsCdo {
    //
    private Strategy strategy;
    @Size(max = 10)
    private String date;
    private Feeling feeling;
    private int count;
}
