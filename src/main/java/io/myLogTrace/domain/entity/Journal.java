package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.entity.sdo.JournalCdo;
import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import lombok.*;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class Journal {
    //
    private String id;
    private String date; // 날짜, 0000-00-00
    private WeatherComment weatherComment; // 날씨와 코멘트
    private FeelingComment feelingComment; // 감정과 코멘트
    private String contents; // 일기 내용
    private String imageId1; // 첨부 이미지1
    private String imageId2; // 첨부 이미지2
    private String memo; // 메모
    private boolean saved; // 저장여부, false = 임시저장
    private boolean locked; // 잠금여부
    private Long registeredOn; // 등록일시
    private Long modifiedOn; // 변경일시

    public static Journal create(JournalCdo cdo) {
        //
        if (cdo.getDate().length() > 10 || cdo.getWeatherComment().getComment().length() > 20
                || cdo.getFeelingComment().getComment().length() > 30 || cdo.getContents().length() > 1000
                || cdo.getMemo().length() > 100) {
            throw LogException.of(LENGTH_OVER_ERROR);
        }

        return Journal.builder()
                .date(cdo.getDate())
                .weatherComment(cdo.getWeatherComment())
                .feelingComment(cdo.getFeelingComment())
                .contents(cdo.getContents())
                .imageId1(cdo.getImage1Id())
                .imageId2(cdo.getImage2Id())
                .memo(cdo.getMemo())
                .saved(cdo.getSaved())
                .locked(cdo.getLocked())
                .build();
    }
}
