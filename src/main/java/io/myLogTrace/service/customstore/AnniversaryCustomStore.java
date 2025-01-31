package io.myLogTrace.service.customstore;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.repository.jpo.AnniversaryJpo;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static io.myLogTrace.repository.jpo.QAnniversaryJpo.anniversaryJpo;

@RequiredArgsConstructor
public class AnniversaryCustomStore {
    //
    private final JPAQueryFactory queryFactory;

    public List<Anniversary> findByMonthlyAnniversaries(String date) {
        //
        LocalDate localDate = LocalDate.parse(date);
        String startDay = localDate.with(DayOfWeek.SUNDAY).toString();
        String endDay = localDate.with(DayOfWeek.SATURDAY).toString();

        JPAQuery<AnniversaryJpo> jpaQuery = queryFactory
                .selectFrom(anniversaryJpo)
                .where(anniversaryJpo.date.goe(startDay)
                        .and(anniversaryJpo.date.loe(endDay)))
                .orderBy(anniversaryJpo.date.asc())
                .fetchAll();

        return AnniversaryJpo.toDomains(jpaQuery);
    }
}
