package io.myLogTrace.domain.entity;

import io.myLogTrace.repository.jpa.TranscribedSentenceJpo;
import lombok.*;

import java.util.List;

@Getter
@Setter
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

    public TranscribedSentenceJpo toJpo() {
        //
        TranscribedSentenceJpo jpo = new TranscribedSentenceJpo();
        org.springframework.beans.BeanUtils.copyProperties(this, jpo);
        return jpo;
    }
} 