package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.SettingsCdo;
import io.myLogTrace.domain.vo.FontType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class Settings {
    //
    private String id;
    private String password; // 비밀번호
    private LocalDateTime notificationTime; // 알림 시간
    private boolean isDark; // 다크모드여부
    private FontType fontType; // 폰트
    private Long registeredOn; // 등록일시

    public static Settings create(SettingsCdo cdo) {
        //
        return Settings.builder()
                .password(cdo.getPassword())
                .notificationTime(cdo.getNotificationTime())
                .isDark(cdo.getIsDark())
                .fontType(cdo.getFontType())
                .build();
    }
}
