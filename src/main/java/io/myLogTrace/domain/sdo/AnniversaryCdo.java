package io.myLogTrace.domain.sdo;

import io.myLogTrace.domain.vo.DateType;
import io.myLogTrace.domain.vo.Weight;
import lombok.Getter;

@Getter
public class AnniversaryCdo {
    //
    private DateType dateType;
    private String date;
    private String name;
    private Weight weight;
}