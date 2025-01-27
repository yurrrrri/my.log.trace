package io.myLogTrace.domain.sdo;

import io.myLogTrace.domain.vo.FontType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SettingsCdo {
    //
    private String password;
    private LocalDateTime notificationTime;
    private Boolean isDark;
    private FontType fontType;
}
