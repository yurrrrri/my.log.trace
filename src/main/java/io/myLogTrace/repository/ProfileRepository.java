package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Profile;
import io.myLogTrace.repository.jpa.ProfileJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileJpo, String> {
    //
    Profile findTopByOrderByRegisteredOnDesc();
}
