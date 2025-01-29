package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class JournalCdo {
    //
    @Size(max = 10)
    private String date;
    private WeatherComment weatherComment;
    private FeelingComment feelingComment;
    @Size(min = 1, max = 1000)
    private String contents;
    private String image1Id;
    private String image2Id;
    @Size(max = 100)
    private String memo;
    private Boolean saved;
    private Boolean locked;
}
