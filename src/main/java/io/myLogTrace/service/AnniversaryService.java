package io.myLogTrace.service;

import io.myLogTrace.repository.AnniversaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnniversaryService {
    //
    private final AnniversaryRepository anniversaryRepository;
}
