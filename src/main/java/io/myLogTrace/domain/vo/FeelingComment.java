package io.myLogTrace.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class FeelingComment {
  //
  @Enumerated(EnumType.STRING)
  private Feeling feeling;
  @Column(length = 60, insertable = false, updatable = false)
  private String comment;
}
