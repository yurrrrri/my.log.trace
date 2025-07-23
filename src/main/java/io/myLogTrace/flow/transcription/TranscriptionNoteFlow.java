package io.myLogTrace.flow.transcription;

import io.myLogTrace.domain.entity.sdo.TranscribedSentenceCdo;
import io.myLogTrace.domain.entity.sdo.TranscriptionNoteCdo;
import io.myLogTrace.service.TranscriptionNoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/transcription-notes")
@RestController
public class TranscriptionNoteFlow {
    //
    private final TranscriptionNoteService noteService;

    @PostMapping("")
    public String create(@Valid @RequestBody TranscriptionNoteCdo cdo) {
        //
        return noteService.create(cdo);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @Valid @RequestBody TranscriptionNoteCdo cdo) {
        //
        return noteService.update(id, cdo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        //
        noteService.delete(id);
        return ResponseEntity.ok(id);
    }

    // 문장 추가
    @PostMapping("/{noteId}/sentences")
    public String addSentence(@PathVariable String noteId, @Valid @RequestBody TranscribedSentenceCdo cdo) {
        //
        return noteService.addSentence(noteId, cdo);
    }

    // 문장 수정
    @PutMapping("/{noteId}/sentences/{sentenceId}")
    public String updateSentence(@PathVariable String noteId, @PathVariable String sentenceId, @Valid @RequestBody TranscribedSentenceCdo cdo) {
        //
        return noteService.updateSentence(noteId, sentenceId, cdo);
    }

    // 문장 삭제
    @DeleteMapping("/{noteId}/sentences/{sentenceId}")
    public ResponseEntity<String> deleteSentence(@PathVariable String noteId, @PathVariable String sentenceId) {
        //
        noteService.deleteSentence(noteId, sentenceId);
        return ResponseEntity.ok(sentenceId);
    }
} 