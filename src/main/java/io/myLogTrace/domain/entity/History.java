package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.common.policy.DateTimePolicy;
import io.myLogTrace.domain.entity.sdo.HistoryCdo;
import lombok.*;

import java.time.LocalDateTime;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.DATETIME_NOT_VALID;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class History {
    //
    private String id;
    private String title; // 학교, 회사명 등
    private String contents; // 세부 내용
    private LocalDateTime startDateTime; // 기간 시작일시
    private LocalDateTime endDateTime; // 기간 종료일시
    private Long registeredOn; // 등록일시
    private Long modifiedOn; // 변경일시

    public static History create(HistoryCdo cdo) {
        //
        if (!DateTimePolicy.isValid(cdo.getStartDateTime(), cdo.getEndDateTime()))
            throw LogException.of(DATETIME_NOT_VALID);

        return History.builder()
                .title(cdo.getTitle())
                .contents(cdo.getContents())
                .startDateTime(cdo.getStartDateTime())
                .endDateTime(cdo.getEndDateTime())
                .build();
    }
}
