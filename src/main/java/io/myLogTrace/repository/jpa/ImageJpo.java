package io.myLogTrace.repository.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Image")
@Table(name = "IMAGE")
public class ImageJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String fileName; // 파일 이름
    private String path; // 파일 경로
    private boolean forJournal; // true: 일기 첨부, false: 자격증 첨부 사진
    @CreatedDate
    private Long registeredOn; // 등록일시
}
