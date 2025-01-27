package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
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
public class Journal {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 10)
    private String date; // 날짜, 0000-00-00
    @Embedded
    private WeatherComment weatherComment; // 날씨와 코멘트
    @Embedded
    private FeelingComment feelingComment; // 감정과 코멘트
    @Column(length = 2000)
    private String contents; // 일기 내용
    private String imageId1; // 첨부 이미지1
    private String imageId2; // 첨부 이미지2
    @Column(length = 200)
    private String memo; // 메모
    private boolean saved; // 저장여부, false = 임시저장
    private boolean locked; // 잠금여부
    @CreatedDate
    private Long registeredOn; // 등록일시
    @LastModifiedDate
    private Long modifiedOn; // 변경일시

    public static Journal create(final String date, final WeatherComment weatherComment, final FeelingComment feelingComment,
                                 final String contents, final @Nullable String imageId1, final @Nullable String imageId2,
                                 final String memo, final boolean saved, final boolean locked) {
        //
        if (date.length() > 10 || weatherComment.getComment().length() > 20 || feelingComment.getComment().length() > 30
                || contents.length() > 1000 || memo.length() > 100) {
            throw LogException.of(LENGTH_OVER_ERROR);
        }

        return Journal.builder()
                .date(date)
                .weatherComment(weatherComment)
                .feelingComment(feelingComment)
                .contents(contents)
                .imageId1(imageId1)
                .imageId2(imageId2)
                .memo(memo)
                .saved(saved)
                .locked(locked)
                .build();
    }
}
