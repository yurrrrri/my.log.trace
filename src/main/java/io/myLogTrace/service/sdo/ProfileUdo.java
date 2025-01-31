package io.myLogTrace.service.sdo;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ProfileUdo {
    //
    @Size(min = 1, max = 20)
    private String name;
    @Size(max = 10)
    private String birthDate;
    @Pattern(regexp = "01[06789]-\\d{3,4}-\\d{4}")
    private String phoneNumber;
    @Size(max = 100)
    private String remark;
}
