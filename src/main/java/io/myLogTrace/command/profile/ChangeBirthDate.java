package io.myLogTrace.command.profile;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ChangeBirthDate {
    //
    private String id;
    @Size(max = 10)
    private String birthDate;
}
