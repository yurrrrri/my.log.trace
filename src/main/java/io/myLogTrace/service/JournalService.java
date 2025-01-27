package io.myLogTrace.service;

import io.myLogTrace.repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JournalService {
    //
    private final JournalRepository journalRepository;
}
