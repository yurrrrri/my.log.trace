package io.myLogTrace.repository.jpo;

import io.myLogTrace.domain.vo.FontType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "SETTINGS")
public class SettingsJpo {
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
}
