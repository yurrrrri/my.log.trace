package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.TranscribedSentenceJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscribedSentenceRepository extends JpaRepository<TranscribedSentenceJpo, String> {
    //
} 