package io.myLogTrace.service;

import io.myLogTrace.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    //
    private final ProfileRepository profileRepository;
}
