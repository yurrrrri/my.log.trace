package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.entity.sdo.CertificationCdo;
import lombok.*;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class Certification {
    //
    private String id;
    private String name; // 명칭
    private String date; // 취득날짜, 0000-00-00
    private String instituteName; // 발급기관명
    private String imageId; // 첨부이미지
    private Long registeredOn; // 등록일시
    private Long modifiedOn; // 변경일시

    public static Certification create(CertificationCdo cdo) {
        //
        if (cdo.getName().length() > 20 || cdo.getDate().length() > 10 || cdo.getInstituteName().length() > 20) {
            throw LogException.of(LENGTH_OVER_ERROR);
        }

        return Certification.builder()
                .name(cdo.getName())
                .date(cdo.getDate())
                .instituteName(cdo.getInstituteName())
                .imageId(cdo.getImageId())
                .build();
    }
}
