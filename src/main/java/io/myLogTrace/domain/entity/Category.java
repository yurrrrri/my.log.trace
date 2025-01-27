package io.myLogTrace.domain.entity;

import io.myLogTrace.common.exception.LogException;
import io.myLogTrace.domain.vo.ColorType;
import jakarta.persistence.*;
import lombok.*;

import static io.myLogTrace.common.exception.LogException.LogExceptionCode.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Category {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 20)
    private String name; // 명칭
    @Enumerated
    private ColorType colorType; // 배경색
    private boolean removed; // 삭제여부

    public static Category create(
            final String name, final ColorType colorType, final boolean removed) {
        //
        if (name.length() > 10) throw LogException.of(LENGTH_OVER_ERROR);

        return Category.builder()
                .name(name)
                .colorType(colorType)
                .removed(removed)
                .build();
    }
}
