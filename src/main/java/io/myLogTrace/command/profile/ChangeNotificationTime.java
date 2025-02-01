package io.myLogTrace.command.profile;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChangeNotificationTime {
    //
    private String id;
    private LocalDateTime notificationTime;
}
