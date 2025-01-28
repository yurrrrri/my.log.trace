package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import lombok.Getter;

@Getter
public class JournalCdo {
    //
    private String date;
    private WeatherComment weatherComment;
    private FeelingComment feelingComment;
    private String contents;
    private String image1Id;
    private String image2Id;
    private String memo;
    private Boolean saved;
    private Boolean locked;
}
