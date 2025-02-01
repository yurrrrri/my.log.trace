package io.myLogTrace.view.sdo;

import io.myLogTrace.domain.vo.Status;
import io.myLogTrace.view.vo.Strategy;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TodoStatsViewCdo {
    //
    private Strategy strategy;
    @Size(max = 6)
    private String date;
    private Status status;
    private int count;
}
