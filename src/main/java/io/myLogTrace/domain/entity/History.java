package io.myLogTrace.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class History {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title; // 학교, 회사명 등
    private String contents; // 세부 내용
    private LocalDateTime startDateTime; // 기간 시작일시
    private LocalDateTime endDateTime; // 기간 종료일시
    @CreatedDate
    private Long registeredOn; // 등록일시
    @LastModifiedDate
    private Long modifiedOn; // 변경일시

    public static History create(
            final String title, final String contents, final LocalDateTime startDateTime, final LocalDateTime endDateTime) {
        //
        return History.builder()
                .title(title)
                .contents(contents)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();
    }
}
