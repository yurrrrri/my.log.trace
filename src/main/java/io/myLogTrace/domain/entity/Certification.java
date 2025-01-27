package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Certification {
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

    public static Certification create(
            final String name, final String date, final String instituteName, final String imageId) {
        //
        if (name.length() > 20 || date.length() > 10 || instituteName.length() > 20) {
            throw LogException.of(LENGTH_OVER_ERROR);
        }

        return Certification.builder()
                .name(name)
                .date(date)
                .instituteName(instituteName)
                .imageId(imageId)
                .build();
    }
}
