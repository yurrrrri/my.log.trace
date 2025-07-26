package io.myLogTrace.service.customstore;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.myLogTrace.domain.entity.Anniversary;
import io.myLogTrace.repository.jpa.AnniversaryJpo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static io.myLogTrace.repository.jpa.QAnniversaryJpo.anniversaryJpo;

@RequiredArgsConstructor
@Repository
public class AnniversaryCustomStore {
  //
  private final JPAQueryFactory queryFactory;

  public List<Anniversary> findDailyAnniversaries(String date) {
    //
    LocalDate localDate = LocalDate.parse(date);
    String startDay = localDate.atStartOfDay().toString();
    String endDay = localDate.plusDays(1).toString();

    JPAQuery<AnniversaryJpo> jpaQuery = queryFactory
      .selectFrom(anniversaryJpo)
      .where(anniversaryJpo.date.goe(startDay)
        .and(anniversaryJpo.date.loe(endDay)))
      .orderBy(anniversaryJpo.date.asc())
      .fetchAll();

    return AnniversaryJpo.toDomains(jpaQuery);
  }

  public List<Anniversary> findWeeklyAnniversaries(String date) {
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

  public List<Anniversary> findMonthlyAnniversaries(String date) {
    //
    LocalDate localDate = LocalDate.parse(date);
    String startDay = localDate.withDayOfMonth(1).toString();
    String endDay = localDate.plusMonths(1).toString();

    JPAQuery<AnniversaryJpo> jpaQuery = queryFactory
      .selectFrom(anniversaryJpo)
      .where(anniversaryJpo.date.goe(startDay)
        .and(anniversaryJpo.date.loe(endDay)))
      .orderBy(anniversaryJpo.date.asc())
      .fetchAll();

    return AnniversaryJpo.toDomains(jpaQuery);
  }
}
