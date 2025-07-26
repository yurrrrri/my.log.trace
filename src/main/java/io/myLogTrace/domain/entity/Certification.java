package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.CertificationCdo;
import io.myLogTrace.repository.jpa.CertificationJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@Setter
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

    public static Certification toDomain(CertificationJpo jpo) {
        //
        Certification certification = new Certification();
        BeanUtils.copyProperties(jpo, certification);
        return certification;
    }

    public static List<Certification> toDomains(List<CertificationJpo> jpos) {
        //
        return jpos.stream().map(Certification::toDomain).toList();
    }

    public CertificationJpo toJpo() {
        //
        CertificationJpo jpo = new CertificationJpo();
        BeanUtils.copyProperties(this, jpo);
        return jpo;
    }
}
