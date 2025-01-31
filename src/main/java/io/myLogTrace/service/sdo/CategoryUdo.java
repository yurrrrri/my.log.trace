package io.myLogTrace.service.sdo;

import io.myLogTrace.domain.vo.ColorType;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CategoryUdo {
    //
    @Size(min = 1, max = 10)
    private String name;
    private ColorType colorType;
}
