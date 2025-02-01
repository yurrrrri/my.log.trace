package io.myLogTrace.command.profile;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ChangeRemark {
    //
    private String id;
    @Size(max = 100)
    private String remark;
}
