package io.myLogTrace.service;

import io.myLogTrace.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryService {
    //
    private final HistoryRepository historyRepository;
}
