package io.myLogTrace.service;

import io.myLogTrace.repository.SettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsService {
    //
    private final SettingsRepository settingsRepository;
}
