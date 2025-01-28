package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.entity.sdo.ProfileCdo;
import lombok.*;

import java.util.Objects;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class Profile {
    //
    private String id;
    private String name; // 이름
    private String birthDate; // 생년월일, 0000-00-00
    private String phoneNumber; // 전화번호
    private String remark; // 한마디
    private Long registeredOn; // 등록일시

    public static Profile create(ProfileCdo cdo) {
        //
        if (cdo.getName().length() > 20 || Objects.requireNonNull(cdo.getBirthDate()).length() > 10
                || cdo.getPhoneNumber().length() > 20 || cdo.getRemark().length() > 100) {
            throw LogException.of(LENGTH_OVER_ERROR);
        }

        return Profile.builder()
                .name(cdo.getName())
                .birthDate(cdo.getBirthDate())
                .phoneNumber(cdo.getPhoneNumber())
                .remark(cdo.getRemark())
                .build();
    }
}
