package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.ImageCdo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Image {
    //
    private String id;
    private String fileName; // 파일 이름
    private String path; // 파일 경로
    private boolean forJournal; // true: 일기 첨부, false: 자격증 첨부 사진
    private Long registeredOn; // 등록일시

    public static Image create(ImageCdo cdo) {
        //
        Image image = new Image();
        BeanUtils.copyProperties(cdo, image);
        return image;
    }
}
