package io.myLogTrace.domain.entity;

import io.myLogTrace.repository.jpa.TranscribedSentenceJpo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TranscribedSentence {
    //
    private String id;
    private int page;
    private String content;

    public static TranscribedSentence toDomain(TranscribedSentenceJpo jpo) {
        //
        return new TranscribedSentence(jpo.getId(), jpo.getPage(), jpo.getContent());
    }

    public static List<TranscribedSentence> toDomains(List<TranscribedSentenceJpo> jpos) {
        //
        return jpos.stream().map(TranscribedSentence::toDomain).toList();
    }
} 