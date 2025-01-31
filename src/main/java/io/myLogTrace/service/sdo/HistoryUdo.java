package io.myLogTrace.service.sdo;

import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HistoryUdo {
    //
    @Size(min = 1, max = 100)
    private String title;
    private String contents;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
