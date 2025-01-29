package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.Status;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoCdo {
    //
    private String categoryId;
    @Size(min = 1, max = 30)
    private String contents;
    @Size(max = 50)
    private String memo;
    private Boolean isPeriod;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Status status;
}
