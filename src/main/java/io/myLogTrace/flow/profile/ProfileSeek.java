package io.myLogTrace.flow.profile;

import io.myLogTrace.domain.entity.Profile;
import io.myLogTrace.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/profiles")
@RestController
public class ProfileSeek {
    //
    private final ProfileService profileService;

    @GetMapping("")
    public Profile findProfile() {
        //
        return profileService.findLatestProfile();
    }
}
