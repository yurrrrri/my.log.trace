package io.myLogTrace.domain.entity;

import io.myLogTrace.domain.entity.sdo.ImageCdo;
import io.myLogTrace.repository.jpa.ImageJpo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
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

    public static Image toDomain(ImageJpo jpo) {
        //
        Image image = new Image();
        BeanUtils.copyProperties(jpo, image);
        return image;
    }

    public static List<Image> toDomains(List<ImageJpo> jpos) {
        //
        return jpos.stream().map(Image::toDomain).toList();
    }

    public ImageJpo toJpo() {
        //
        ImageJpo jpo = new ImageJpo();
        BeanUtils.copyProperties(this, jpo);
        return jpo;
    }
}
