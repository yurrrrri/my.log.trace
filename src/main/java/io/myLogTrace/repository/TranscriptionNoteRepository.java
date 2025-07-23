package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.TranscriptionNoteJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptionNoteRepository extends JpaRepository<TranscriptionNoteJpo, String> {
    //
} 