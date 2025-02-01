package io.myLogTrace.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LogExceptionCode {
    //
    INVALID_PASSWORD("비밀번호를 잘못 입력하셨습니다."),
    DATETIME_NOT_VALID("기간의 시작일시는 마감일시보다 앞서야 합니다."),
    LENGTH_TOO_SHORT("입력값의 길이가 너무 짧습니다."),
    LENGTH_OVER_ERROR("입력값의 길이가 너무 깁니다."),
    DATA_ALREADY_EXISTS("중복된 데이터가 존재합니다."),
    DATA_NOT_FOUND("데이터를 찾을 수 없습니다.");

    private final String value;
}
