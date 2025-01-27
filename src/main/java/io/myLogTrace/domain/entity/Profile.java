package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Objects;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Profile {
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

    public static Profile create(
            final String name, final @Nullable String birthDate, final String phoneNumber, final String remark) {
        //
        if (name.length() > 20 || Objects.requireNonNull(birthDate).length() > 10
                || phoneNumber.length() > 20 || remark.length() > 100) {
            throw LogException.of(LENGTH_OVER_ERROR);
        }

        return Profile.builder()
                .name(name)
                .birthDate(birthDate)
                .phoneNumber(phoneNumber)
                .remark(remark)
                .build();
    }
}
