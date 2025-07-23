package io.myLogTrace.repository.jpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.List;

@Getter
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
} 