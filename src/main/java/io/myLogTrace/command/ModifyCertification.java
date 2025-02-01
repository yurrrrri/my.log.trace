package io.myLogTrace.command;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ModifyCertification {
    //
    private String id;
    @Size(min = 1, max = 20)
    private String name;
    @Size(max = 10)
    private String date;
    @Size(min = 1, max = 20)
    private String instituteName;
    private String imageId;
}
