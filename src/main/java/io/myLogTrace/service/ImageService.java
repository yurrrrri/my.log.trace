package io.myLogTrace.service;

import io.myLogTrace.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    //
    private final ImageRepository imageRepository;
}
