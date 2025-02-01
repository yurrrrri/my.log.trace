package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.ProfileCdo;
import io.myLogTrace.domain.vo.FontType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Objects;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Profile {
    //
    private String id;
    private String name; // 이름
    private String birthDate; // 생년월일, 0000-00-00
    private String phoneNumber; // 전화번호
    private String remark; // 한마디
    private String password; // 비밀번호
    private LocalDateTime notificationTime; // 알림 시간
    private boolean isDark; // 다크모드여부
    private FontType fontType; // 폰트
    private Long registeredOn; // 등록일시
    private Long modifiedOn; // 변경일시

    public void changeName(String name) {
        this.name = name;
    }

    public void changeBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeRemark(String remark) {
        this.remark = remark;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changeNotificationTime(LocalDateTime notificationTime) {
        this.notificationTime = notificationTime;
    }

    public void changeDarkMode() {
        this.isDark = !isDark;
    }

    public void changeFontType(FontType fontType) {
        this.fontType = fontType;
    }

    public static Profile create(ProfileCdo cdo) {
        //
        if (cdo.getName().length() > 20 || Objects.requireNonNull(cdo.getBirthDate()).length() > 10
                || cdo.getPhoneNumber().length() > 20 || cdo.getRemark().length() > 100) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        }

        Profile profile = new Profile();
        BeanUtils.copyProperties(cdo, profile);
        return profile;
    }
}
