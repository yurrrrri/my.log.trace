package io.myLogTrace.repository.jpa;

import com.querydsl.jpa.impl.JPAQuery;
import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.domain.vo.DateType;
import io.myLogTrace.domain.vo.Weight;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Anniversary")
@Table(name = "ANNIVERSARY")
public class AnniversaryJpo {
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

    public static List<Anniversary> toDomains(JPAQuery<AnniversaryJpo> jpos) {
        //
        return jpos.stream().map(Anniversary::toDomain).toList();
    }
}