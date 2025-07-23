package io.myLogTrace.service;

import io.myLogTrace.domain.entity.TranscriptionNote;
import io.myLogTrace.domain.entity.sdo.TranscriptionNoteCdo;
import io.myLogTrace.domain.entity.sdo.TranscribedSentenceCdo;
import io.myLogTrace.repository.TranscriptionNoteRepository;
import io.myLogTrace.repository.TranscribedSentenceRepository;
import io.myLogTrace.repository.jpa.TranscriptionNoteJpo;
import io.myLogTrace.repository.jpa.TranscribedSentenceJpo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TranscriptionNoteService {
    //
    private final TranscriptionNoteRepository noteRepository;
    private final TranscribedSentenceRepository sentenceRepository;

    public String create(TranscriptionNoteCdo cdo) {
        //
        TranscriptionNoteJpo note = new TranscriptionNoteJpo();
        BeanUtils.copyProperties(cdo, note);
        if (cdo.getSentences() != null) {
            List<TranscribedSentenceJpo> sentences = cdo.getSentences().stream().map(s -> {
                TranscribedSentenceJpo jpo = new TranscribedSentenceJpo();
                BeanUtils.copyProperties(s, jpo);
                jpo.setNote(note);
                return jpo;
            }).toList();
            note.getSentences().clear();
            note.getSentences().addAll(sentences);
        }
        noteRepository.save(note);
        return note.getId();
    }

    public String update(String id, TranscriptionNoteCdo cdo) {
        //
        TranscriptionNoteJpo note = getNote(id);
        BeanUtils.copyProperties(cdo, note);
        // 문장 전체 교체
        if (cdo.getSentences() != null) {
            note.getSentences().clear();
            List<TranscribedSentenceJpo> sentences = cdo.getSentences().stream().map(s -> {
                TranscribedSentenceJpo jpo = new TranscribedSentenceJpo();
                BeanUtils.copyProperties(s, jpo);
                jpo.setNote(note);
                return jpo;
            }).toList();
            note.getSentences().addAll(sentences);
        }
        noteRepository.save(note);
        return note.getId();
    }

    public void delete(String id) {
        //
        noteRepository.deleteById(id);
    }

    public TranscriptionNoteJpo find(String id) {
        //
        return getNote(id);
    }

    public List<TranscriptionNoteJpo> findAll() {
        //
        return noteRepository.findAll();
    }

    public List<TranscriptionNote> toDomains() {
        //
        return TranscriptionNote.toDomains(this.findAll());
    }

    public TranscriptionNote findById(String id) {
        //
        return TranscriptionNote.toDomain(getNote(id));
    }

    // 문장 추가
    public String addSentence(String noteId, TranscribedSentenceCdo cdo) {
        //
        TranscriptionNoteJpo note = getNote(noteId);
        TranscribedSentenceJpo sentence = new TranscribedSentenceJpo();
        BeanUtils.copyProperties(cdo, sentence);
        sentence.setNote(note);
        sentenceRepository.save(sentence);
        note.getSentences().add(sentence);
        noteRepository.save(note);
        return sentence.getId();
    }

    // 문장 수정
    public String updateSentence(String noteId, String sentenceId, TranscribedSentenceCdo cdo) {
        //
        TranscribedSentenceJpo sentence = getSentence(sentenceId);
        if (!sentence.getNote().getId().equals(noteId)) throw new EntityNotFoundException();
        BeanUtils.copyProperties(cdo, sentence);
        sentenceRepository.save(sentence);
        return sentence.getId();
    }

    // 문장 삭제
    public void deleteSentence(String noteId, String sentenceId) {
        //
        TranscribedSentenceJpo sentence = getSentence(sentenceId);
        if (!sentence.getNote().getId().equals(noteId)) throw new EntityNotFoundException();
        sentenceRepository.deleteById(sentenceId);
    }

    private TranscriptionNoteJpo getNote(String id) {
        //
        Optional<TranscriptionNoteJpo> opt = noteRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException();
        return opt.get();
    }

    private TranscribedSentenceJpo getSentence(String id) {
        //
        Optional<TranscribedSentenceJpo> opt = sentenceRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException();
        return opt.get();
    }
} 