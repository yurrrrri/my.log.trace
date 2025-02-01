package io.myLogTrace.command;

import io.myLogTrace.domain.vo.Weight;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ModifyAnniversary {
    //
    private String id;
    @Size(max = 10)
    private String date;
    @Size(min = 1, max = 20)
    private String name;
    private Weight weight;
}