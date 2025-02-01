package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.FontType;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProfileCdo {
    //
    @Size(min = 1, max = 20)
    private String name;
    @Size(max = 10)
    private String birthDate;
    @Pattern(regexp = "01[06789]-\\d{3,4}-\\d{4}")
    private String phoneNumber;
    @Size(max = 100)
    private String remark;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+~\\-={}:;\"'<>,.?/]).{8,}$\n")
    private String password; // 비밀번호
    private transient LocalDateTime notificationTime; // 알림 시간
    private transient boolean isDark; // 다크모드여부
    private transient FontType fontType; // 폰트
}
