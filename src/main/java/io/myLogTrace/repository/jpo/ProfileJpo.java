package io.myLogTrace.repository.jpo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
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
    @CreatedDate
    private Long registeredOn; // 등록일시
}
