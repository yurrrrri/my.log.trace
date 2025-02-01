package io.myLogTrace.command.journal;

import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ModifyJournal {
    //
    private String id;
    @Size(max = 10)
    private String date;
    private WeatherComment weatherComment;
    private FeelingComment feelingComment;
    @Size(min = 1, max = 1000)
    private String contents;
    @Size(max = 100)
    private String memo;
}
