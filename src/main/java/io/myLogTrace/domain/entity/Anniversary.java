package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.AnniversaryCdo;
import io.myLogTrace.domain.vo.DateType;
import io.myLogTrace.domain.vo.Weight;
import io.myLogTrace.repository.jpa.AnniversaryJpo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Anniversary {
    //
    private String id;
    private DateType dateType; // 날짜 타입(공휴일/특별한 날)
    private String date; // 날짜, 0000-00-00
    private String name; // 명칭
    private Weight weight; // 중요도, 날짜 타입이 '특별한 날'인 경우에만
    private Long registeredOn; // 등록일시
    private Long modifiedOn; // 변경일시

    public static Anniversary toDomain(AnniversaryJpo jpo) {
        //
        Anniversary anniversary = new Anniversary();
        BeanUtils.copyProperties(jpo, anniversary);
        return anniversary;
    }

    public static Anniversary create(AnniversaryCdo cdo) {
        //
        if (cdo.getName().length() > 20) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        }
        Anniversary anniversary = new Anniversary();
        BeanUtils.copyProperties(cdo, anniversary);
        return anniversary;
    }
}