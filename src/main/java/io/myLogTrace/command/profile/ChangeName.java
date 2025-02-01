package io.myLogTrace.command.profile;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ChangeName {
    //
    private String id;
    @Size(min = 1, max = 20)
    private String name;
}
