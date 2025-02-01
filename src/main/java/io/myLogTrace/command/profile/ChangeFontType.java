package io.myLogTrace.command.profile;

import io.myLogTrace.domain.vo.FontType;
import lombok.Getter;

@Getter
public class ChangeFontType {
    //
    private String id;
    private FontType fontType;
}
