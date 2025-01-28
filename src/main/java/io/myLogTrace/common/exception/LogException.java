package io.myLogTrace.common.exception;

import lombok.Getter;

@Getter
public class LogException extends RuntimeException {
    //
    @Getter
    public enum LogExceptionCode {
        //
        DATETIME_NOT_VALID("기간의 시작일시는 마감일시보다 앞서야 합니다."),
        LENGTH_TOO_SHORT("입력값의 길이가 너무 짧습니다."),
        LENGTH_OVER_ERROR("입력값의 길이가 너무 깁니다.");

        private LogExceptionCode(String value) {}
    }

    public LogException(String message) {
        super(message);
    }

    public static LogException of(LogExceptionCode code) {
        return new LogException(code.name());
    }
}































