package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.Status;
import io.myLogTrace.domain.vo.Strategy;
import lombok.Getter;

@Getter
public class TodoStatsCdo {
    //
    private Strategy strategy;
    private String date;
    private Status status;
    private int count;
}
