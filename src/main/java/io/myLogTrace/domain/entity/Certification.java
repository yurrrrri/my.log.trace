package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.CertificationCdo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        }

        Certification certification = new Certification();
        BeanUtils.copyProperties(cdo, certification);
        return certification;
    }
}
