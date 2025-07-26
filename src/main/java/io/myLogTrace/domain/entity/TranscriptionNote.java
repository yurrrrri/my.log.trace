package io.myLogTrace.domain.entity;

import io.myLogTrace.repository.jpa.TranscriptionNoteJpo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TranscriptionNote {
    //
    private String id;
    private String title;
    private String author;
    private String coverImageId;
    private List<TranscribedSentence> sentences;
    private String memo;
    private Long registeredOn;
    private Long modifiedOn;

    public static TranscriptionNote toDomain(io.myLogTrace.repository.jpa.TranscriptionNoteJpo jpo) {
        //
        return new TranscriptionNote(
            jpo.getId(),
            jpo.getTitle(),
            jpo.getAuthor(),
            jpo.getCoverImageId(),
            jpo.getSentences() == null ? null : jpo.getSentences().stream().map(io.myLogTrace.domain.entity.TranscribedSentence::toDomain).toList(),
            jpo.getMemo(),
            jpo.getRegisteredOn(),
            jpo.getModifiedOn()
        );
    }

    public static List<TranscriptionNote> toDomains(List<TranscriptionNoteJpo> jpos) {
        //
        return jpos.stream().map(TranscriptionNote::toDomain).toList();
    }

    public TranscriptionNoteJpo toJpo() {
        //
        TranscriptionNoteJpo jpo = new TranscriptionNoteJpo();
        org.springframework.beans.BeanUtils.copyProperties(this, jpo);
        return jpo;
    }
} 