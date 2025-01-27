package io.myLogTrace.domain.sdo;

import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import lombok.Getter;

import java.io.File;

@Getter
public class JournalCdo {
    //
    private String date;
    private WeatherComment weatherComment;
    private FeelingComment feelingComment;
    private String contents;
    private File image1;
    private File image2;
    private String memo;
    private Boolean saved;
    private Boolean locked;
}
