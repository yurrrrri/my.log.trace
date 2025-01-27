package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.vo.FontType;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Settings {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String password; // 비밀번호
    private LocalDateTime notificationTime; // 알림 시간
    private boolean isDark; // 다크모드여부
    private FontType fontType; // 폰트
    @CreatedDate
    private Long registeredOn; // 등록일시

    public static Settings create(
            final @Nullable String password, final @Nullable LocalDateTime notificationTime,
            final boolean isDark, final @Nullable FontType fontType) {
        //
        return Settings.builder()
                .password(password)
                .notificationTime(notificationTime)
                .isDark(isDark)
                .fontType(fontType)
                .build();
    }
}
