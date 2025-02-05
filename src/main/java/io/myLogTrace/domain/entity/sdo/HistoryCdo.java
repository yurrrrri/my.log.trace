package io.myLogTrace.domain.entity.sdo;

import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HistoryCdo {
    //
    @Size(min = 1, max = 100)
    private String title;
    private String contents;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
