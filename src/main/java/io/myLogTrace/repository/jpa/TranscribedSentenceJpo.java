package io.myLogTrace.repository.jpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "TranscribedSentence")
@Table(name = "TRANSCRIBED_SENTENCE")
public class TranscribedSentenceJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int page;
    @Column(length = 1000)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id")
    private TranscriptionNoteJpo note;
} 