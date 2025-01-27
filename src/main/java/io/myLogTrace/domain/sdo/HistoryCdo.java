package io.myLogTrace.domain.sdo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HistoryCdo {
    //
    private String title;
    private String contents;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
