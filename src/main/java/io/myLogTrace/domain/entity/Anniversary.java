package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.vo.DateType;
import io.myLogTrace.domain.vo.Weight;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Anniversary {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Enumerated(EnumType.STRING)
    private DateType dateType; // 날짜 타입(공휴일/특별한 날)
    @Column(length = 10)
    private String date; // 날짜, 0000-00-00
    @Column(length = 40)
    private String name; // 명칭
    @Enumerated(EnumType.STRING)
    private Weight weight; // 중요도, 날짜 타입이 '특별한 날'인 경우에만
    @CreatedDate
    private Long registeredOn; // 등록일시
    @LastModifiedDate
    private Long modifiedOn; // 변경일시

    public static Anniversary create(
            final DateType dateType, final String date, final String name, final @Nullable Weight weight) {
        //
        if (name.length() > 20) throw LogException.of(LENGTH_OVER_ERROR);

        return Anniversary.builder()
                .dateType(dateType)
                .date(date)
                .name(name)
                .weight(weight)
                .build();
    }
}