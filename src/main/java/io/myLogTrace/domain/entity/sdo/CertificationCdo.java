package io.myLogTrace.domain.entity.sdo;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CertificationCdo {
    //
    @Size(min = 1, max = 20)
    private String name;
    @Size(max = 10)
    private String date;
    @Size(min = 1, max = 20)
    private String instituteName;
    private String imageId;
}
