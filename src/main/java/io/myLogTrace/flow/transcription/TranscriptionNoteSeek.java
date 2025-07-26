package io.myLogTrace.flow.transcription;

import io.myLogTrace.domain.entity.TranscriptionNote;
import io.myLogTrace.repository.TranscriptionNoteRepository;
import io.myLogTrace.service.TranscriptionNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/transcription-notes")
@RestController
public class TranscriptionNoteSeek {
    //
    private final TranscriptionNoteRepository transcriptionNoteRepository;
    private final TranscriptionNoteService noteService;

    @GetMapping("")
    public List<TranscriptionNote> findAll() {
        //
        return TranscriptionNote.toDomains(transcriptionNoteRepository.findAll());
    }

    @GetMapping("/{id}")
    public TranscriptionNote findNote(@PathVariable String id) {
        //
        return noteService.findById(id);
    }
} 