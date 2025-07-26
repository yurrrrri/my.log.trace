package io.myLogTrace.flow.profile;

import io.myLogTrace.command.profile.*;
import io.myLogTrace.domain.entity.sdo.ProfileCdo;
import io.myLogTrace.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/profiles")
@RestController
public class ProfileFlow {
    //
    private final ProfileService profileService;

    @PostMapping("")
    public String create(ProfileCdo cdo) {
        //
        return profileService.create(cdo);
    }

    @PatchMapping(value = "", headers = { "command=ChangeName"})
    public String update(@Valid @RequestBody ChangeName command) {
        //
        return profileService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangeBirthDate"})
    public String update(@Valid @RequestBody ChangeBirthDate command) {
        //
        return profileService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangePhoneNumber"})
    public String update(@Valid @RequestBody ChangePhoneNumber command) {
        //
        return profileService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangeRemark"})
    public String update(@Valid @RequestBody ChangeRemark command) {
        //
        return profileService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangePassword"})
    public String update(@Valid @RequestBody ChangePassword command) {
        //
        return profileService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangeNotificationTime"})
    public String update(@Valid @RequestBody ChangeNotificationTime command) {
        //
        return profileService.update(command);
    }

    @PatchMapping(value = "", headers = { "command=ChangeDarkMode"})
    public String update(@PathVariable String id) {
        //
        return profileService.update(id);
    }

    @PatchMapping(value = "", headers = { "command=ChangeFontType"})
    public String update(@Valid @RequestBody ChangeFontType command) {
        //
        return profileService.update(command);
    }
}
