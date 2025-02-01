package io.myLogTrace.service.customstore;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.myLogTrace.domain.entity.Journal;
import io.myLogTrace.repository.jpa.JournalJpo;
import lombok.RequiredArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static io.myLogTrace.repository.jpa.QJournalJpo.journalJpo;

@RequiredArgsConstructor
public class JournalCustomStore {
    //
    private final JPAQueryFactory queryFactory;

    public List<Journal> findWeeklyJournals(String date) {
        //
        LocalDate localDate = LocalDate.parse(date);
        String startDay = localDate.with(DayOfWeek.SUNDAY).toString();
        String endDay = localDate.with(DayOfWeek.SATURDAY).toString();

        JPAQuery<JournalJpo> jpaQuery = queryFactory
                .selectFrom(journalJpo)
                .where(journalJpo.date.goe(startDay)
                        .and(journalJpo.date.loe(endDay)))
                .orderBy(journalJpo.date.asc())
                .fetchAll();

        return JournalJpo.toDomains(jpaQuery);
    }
}
