package io.myLogTrace.flow.transcription;

import io.myLogTrace.domain.entity.TranscriptionNote;
import io.myLogTrace.service.TranscriptionNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/transcription-notes")
@RestController
public class TranscriptionNoteSeek {
    //
    private final TranscriptionNoteService noteService;

    @GetMapping("")
    public List<TranscriptionNote> findAll() {
        //
        return noteService.toDomains();
    }

    @GetMapping("/{id}")
    public TranscriptionNote findNote(@PathVariable String id) {
        //
        return noteService.findById(id);
    }
} 