package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.ColorType;
import lombok.Getter;

@Getter
public class CategoryCdo {
    //
    private String name;
    private ColorType colorType;
    private Boolean removed;
}
