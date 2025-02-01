package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {
    //
    Profile findTopByOrderByRegisteredOnDesc();
}
