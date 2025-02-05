package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.CategoryCdo;
import io.myLogTrace.domain.vo.ColorType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Category {
    //
    private String id;
    private String name; // 명칭
    private ColorType colorType; // 배경색
    private Integer orderNo; // 정렬 순서
    private boolean removed; // 삭제여부

    public void setRemovedTrue() {
        this.removed = true;
    }

    public void setRemovedFalse() {
        this.removed = false;
    }

    public static Category create(CategoryCdo cdo) {
        //
        if (cdo.getName().length() > 10) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
        }
        Category Category = new Category();
        BeanUtils.copyProperties(cdo, Category);
        Category.setRemovedFalse();
        return Category;
    }
}
