package io.myLogTrace.command.profile;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ChangePhoneNumber {
    //
    private String id;
    @Pattern(regexp = "01[06789]-\\d{3,4}-\\d{4}")
    private String phoneNumber;
}
