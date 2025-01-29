package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.vo.ColorType;
import lombok.*;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class Category {
    //
    private String id;
    private String name; // 명칭
    private ColorType colorType; // 배경색
    private boolean removed; // 삭제여부

    public static Category create(
            final String name, final ColorType colorType, final boolean removed) {
        //
        if (name.length() > 10) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        }

        return Category.builder()
                .name(name)
                .colorType(colorType)
                .removed(removed)
                .build();
    }
}
