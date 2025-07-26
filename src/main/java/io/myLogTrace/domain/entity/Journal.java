package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.JournalCdo;
import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import io.myLogTrace.repository.jpa.JournalJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    public void changeImages(String imageId1, String imageId2) {
        this.imageId1 = imageId1;
        this.imageId2 = imageId2;
    }

    public void saved() {
        this.saved = true;
    }

    public void changeLocked() {
        this.locked = !locked;
    }

    public static Journal create(JournalCdo cdo) {
        //
        if (cdo.getDate().length() > 10 || cdo.getWeatherComment().getComment().length() > 20
                || cdo.getFeelingComment().getComment().length() > 30 || cdo.getContents().length() > 1000
                || cdo.getMemo().length() > 100) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        }
        Journal journal = new Journal();
        BeanUtils.copyProperties(cdo, journal);
        return journal;
    }

    public static Journal toDomain(JournalJpo jpo) {
        //
        Journal journal = new Journal();
        BeanUtils.copyProperties(jpo, journal);
        return journal;
    }

    public static List<Journal> toDomains(List<JournalJpo> jpos) {
        //
        return jpos.stream().map(Journal::toDomain).toList();
    }

    public JournalJpo toJpo() {
        //
        JournalJpo jpo = new JournalJpo();
        BeanUtils.copyProperties(this, jpo);
        return jpo;
    }
}
