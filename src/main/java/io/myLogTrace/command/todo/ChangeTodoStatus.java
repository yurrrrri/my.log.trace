package io.myLogTrace.command.todo;

import io.myLogTrace.domain.vo.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ChangeTodoStatus {
    //
    private String id;
    @NotNull
    private Status status;
}
