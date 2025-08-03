package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.CategoryCdo;
import io.myLogTrace.domain.vo.ColorType;
import io.myLogTrace.repository.jpa.CategoryJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static io.myLogTrace.common.exception.LogExceptionCode.LENGTH_OVER_ERROR;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Category {
  //
  private String id;
  private String name; // 명칭
  private ColorType colorType; // 배경색
  private Integer orderNo; // 정렬 순서

  public static Category create(CategoryCdo cdo) {
    //
    if (cdo.getName().length() > 10) {
      throw new IllegalArgumentException(LENGTH_OVER_ERROR.name());
    }
    Category category = new Category();
    BeanUtils.copyProperties(cdo, category);
    return category;
  }

  public static Category toDomain(CategoryJpo jpo) {
    //
    Category category = new Category();
    BeanUtils.copyProperties(jpo, category);
    return category;
  }

  public static List<Category> toDomains(List<CategoryJpo> jpos) {
    //
    return jpos.stream().map(Category::toDomain).toList();
  }

  public CategoryJpo toJpo() {
    //
    CategoryJpo jpo = new CategoryJpo();
    BeanUtils.copyProperties(this, jpo);
    return jpo;
  }
}
