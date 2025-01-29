package io.myLogTrace.domain.entity.sdo;

import io.myLogTrace.domain.vo.DateType;
import io.myLogTrace.domain.vo.Weight;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AnniversaryCdo {
    //
    private DateType dateType;
    @Size(max = 10)
    private String date;
    @Size(min = 1, max = 20)
    private String name;
    private Weight weight;
}