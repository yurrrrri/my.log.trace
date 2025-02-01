package io.myLogTrace.service;

import io.myLogTrace.repository.ImageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageService {
    //
    private final ImageRepository imageRepository;
}
