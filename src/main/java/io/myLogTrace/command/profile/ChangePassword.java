package io.myLogTrace.command.profile;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ChangePassword {
    //
    private String id;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+~\\-={}:;\"'<>,.?/]).{8,}$\n")
    private String oldPassword;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+~\\-={}:;\"'<>,.?/]).{8,}$\n")
    private String newPassword;
}
