package io.myLogTrace.repository.jpa;

import io.myLogTrace.domain.vo.ColorType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Category")
@Table(name = "CATEGORY")
public class CategoryJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 20)
    private String name; // 명칭
    @Enumerated
    private ColorType colorType; // 배경색
    private Integer orderNo; // 정렬 순서
    private boolean removed; // 삭제여부
}
