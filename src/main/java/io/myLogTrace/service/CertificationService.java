package io.myLogTrace.service;

import io.myLogTrace.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificationService {
    //
    private final CertificationRepository certificationRepository;
}
