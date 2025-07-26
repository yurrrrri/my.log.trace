package io.myLogTrace.service;

import io.myLogTrace.command.profile.*;
import io.myLogTrace.common.exception.InvalidPasswordException;
import io.myLogTrace.domain.entity.Profile;
import io.myLogTrace.domain.entity.sdo.ProfileCdo;
import io.myLogTrace.repository.ProfileRepository;
import io.myLogTrace.repository.jpa.ProfileJpo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_NOT_FOUND;
import static io.myLogTrace.common.exception.LogExceptionCode.INVALID_PASSWORD;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileService {
    //
    private final ProfileRepository profileRepository;

    public Profile findLatestProfile() {
        //
        return profileRepository.findTopByOrderByRegisteredOnDesc();
    }

    public String create(ProfileCdo cdo) {
        //
        Profile entity = Profile.create(cdo);
        ProfileJpo profileJpo = profileRepository.save(entity.toJpo());
        return profileJpo.getId();
    }

    public String update(ChangeName command) {
        //
        Profile profile = this.getProfile(command.getId());
        profile.changeName(command.getName());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    public String update(ChangeBirthDate command) {
        //
        Profile profile = this.getProfile(command.getId());
        profile.changeBirthDate(command.getBirthDate());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    public String update(ChangePhoneNumber command) {
        //
        Profile profile = this.getProfile(command.getId());
        profile.changePhoneNumber(command.getPhoneNumber());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    public String update(ChangeRemark command) {
        //
        Profile profile = this.getProfile(command.getId());
        profile.changeRemark(command.getRemark());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    public String update(ChangePassword command) {
        //
        Profile profile = this.getProfile(command.getId());
        if (!profile.getPassword().equals(command.getOldPassword())) {
            throw new InvalidPasswordException(INVALID_PASSWORD.name());
        }

        profile.changePassword(command.getNewPassword());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    public String update(ChangeNotificationTime command) {
        //
        Profile profile = this.getProfile(command.getId());
        profile.changeNotificationTime(command.getNotificationTime());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    public String update(String id) {
        //
        Profile profile = this.getProfile(id);
        profile.changeDarkMode();
        profileRepository.save(profile.toJpo());
        return id;
    }

    public String update(ChangeFontType command) {
        //
        Profile profile = this.getProfile(command.getId());
        profile.changeFontType(command.getFontType());
        profileRepository.save(profile.toJpo());
        return command.getId();
    }

    private Profile getProfile(String id) {
        //
        Optional<ProfileJpo> opt = profileRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return Profile.toDomain(opt.get());
    }
}
