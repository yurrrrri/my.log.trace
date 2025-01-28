package io.myLogTrace.repository.jpo;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "CERTIFICATION")
public class CertificationJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40)
    private String name; // 명칭
    @Column(length = 10)
    private String date; // 취득날짜, 0000-00-00
    @Column(length = 40)
    private String instituteName; // 발급기관명
    private String imageId; // 첨부이미지
    @CreatedDate
    private Long registeredOn; // 등록일시
    @LastModifiedDate
    private Long modifiedOn; // 변경일시
}
