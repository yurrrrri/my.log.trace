package io.myLogTrace.common.policy;

import java.time.LocalDateTime;

public class DateTimePolicy {
    //
    public static boolean isValid(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        //
        return startDateTime.isBefore(endDateTime);
    }
}
