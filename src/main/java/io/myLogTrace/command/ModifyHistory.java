package io.myLogTrace.command;

import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ModifyHistory {
    //
    private String id;
    @Size(min = 1, max = 100)
    private String title;
    private String contents;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
