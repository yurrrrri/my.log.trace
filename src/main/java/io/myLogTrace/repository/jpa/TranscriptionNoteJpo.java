package io.myLogTrace.repository.jpa;

import io.myLogTrace.domain.entity.TranscriptionNote;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "TranscriptionNote")
@Table(name = "TRANSCRIPTION_NOTE")
public class TranscriptionNoteJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 200)
    private String title;
    @Column(length = 100)
    private String author;
    private String coverImageId;
    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TranscribedSentenceJpo> sentences;
    @Column(length = 500)
    private String memo;
    @CreatedDate
    private Long registeredOn;
    @LastModifiedDate
    private Long modifiedOn;

    public List<TranscriptionNote> toDomains(List<TranscriptionNoteJpo> jpos) {
        //
        return jpos.stream().map(TranscriptionNote::toDomain).toList();
    }
} 