package io.myLogTrace.service;

import io.myLogTrace.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    //
    private final HistoryRepository historyRepository;
}
