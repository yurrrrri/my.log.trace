package io.myLogTrace.repository.jpa;

import io.myLogTrace.domain.vo.FontType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Profile")
@Table(name = "PROFILE")
public class ProfileJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40)
    private String name; // 이름
    @Column(length = 10)
    private String birthDate; // 생년월일, 0000-00-00
    @Column(length = 20)
    private String phoneNumber; // 전화번호
    @Column(length = 200)
    private String remark; // 한마디
    private String password; // 비밀번호
    private LocalDateTime notificationTime; // 알림 시간
    private boolean isDark; // 다크모드여부
    @Enumerated(EnumType.STRING)
    private FontType fontType; // 폰트
    @CreatedDate
    private Long registeredOn; // 등록일시
    @LastModifiedDate
    private Long modifiedOn; // 변경일시
}
