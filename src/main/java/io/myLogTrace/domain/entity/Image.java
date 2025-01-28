package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.ImageCdo;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
public class Image {
    //
    private String id;
    private String fileName; // 파일 이름
    private String path; // 파일 경로
    private boolean forJournal; // true: 일기 첨부, false: 자격증 첨부 사진
    private Long registeredOn; // 등록일시

    public static Image create(ImageCdo cdo) {
        //
        return Image.builder()
                .fileName(cdo.getFileName())
                .path(cdo.getPath())
                .forJournal(cdo.isForJournal())
                .build();
    }
}
