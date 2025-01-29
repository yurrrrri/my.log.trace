package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.ColorType;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CategoryCdo {
    //
    @Size(min = 1, max = 10)
    private String name;
    private ColorType colorType;
    private Boolean removed;
}
