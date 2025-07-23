package io.myLogTrace.domain.entity.sdo;

import lombok.Getter;
import java.util.List;

@Getter
public class TranscriptionNoteCdo {
    //
    private String title;
    private String author;
    private String coverImageId;
    private List<TranscribedSentenceCdo> sentences;
    private String memo;
} 