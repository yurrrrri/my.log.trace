package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepository extends JpaRepository<Settings, String> {
}
