package io.myLogTrace.service.sdo;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CertificationUdo {
    //
    @Size(min = 1, max = 20)
    private String name;
    @Size(max = 10)
    private String date;
    @Size(min = 1, max = 20)
    private String instituteName;
    private String imageId;
}
