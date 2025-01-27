package io.myLogTrace.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class WeatherComment {
    //
    @Enumerated(EnumType.STRING)
    private Weather weather;
    @Column(length = 40)
    private String comment;
}
