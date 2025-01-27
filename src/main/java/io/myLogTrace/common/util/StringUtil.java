package io.myLogTrace.common.util;

import jakarta.annotation.Nullable;

public class StringUtil {
    //
    public static String strip(@Nullable String value) {
        //
        return value == null ? "" : value.strip();
    }
}
