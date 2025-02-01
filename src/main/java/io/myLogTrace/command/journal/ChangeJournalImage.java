package io.myLogTrace.command.journal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ChangeJournalImage {
    //
    private String id;
    @NotNull
    private String image1Id;
    @NotNull
    private String image2Id;
}
