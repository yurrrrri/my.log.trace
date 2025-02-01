package io.myLogTrace.service;

import io.myLogTrace.repository.CertificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CertificationService {
    //
    private final CertificationRepository certificationRepository;
}
