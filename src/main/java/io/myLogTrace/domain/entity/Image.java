package io.myLogTrace.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
public class Image {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fileName; // 파일 이름
    private String path; // 파일 경로
    private boolean forJournal; // true: 일기 첨부, false: 자격증 첨부 사진
    @CreatedDate
    private Long registeredOn; // 등록일시

    public static Image create(final String fileName, final String path, final boolean forJournal) {
        //
        return Image.builder()
                .fileName(fileName)
                .path(path)
                .forJournal(forJournal)
                .build();
    }
}
