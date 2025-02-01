package io.myLogTrace.command.category;

import io.myLogTrace.domain.vo.ColorType;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ModifyCategory {
    //
    private String id;
    @Size(min = 1, max = 10)
    private String name;
    private ColorType colorType;
}
