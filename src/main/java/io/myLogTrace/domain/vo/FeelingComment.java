package io.myLogTrace.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class FeelingComment {
    //
    @Enumerated
    private Feeling feeling;
    @Column(length = 60)
    private String comment;
}
