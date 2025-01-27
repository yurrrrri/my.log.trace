package io.myLogTrace.domain.sdo;

import io.myLogTrace.domain.vo.Status;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoCdo {
    //
    private String categoryId;
    private String contents;
    private String memo;
    private Boolean isPeriod;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Status status;
}
