package io.myLogTrace.repository.jpa;

import com.querydsl.jpa.impl.JPAQuery;
import io.myLogTrace.domain.entity.Journal;
import io.myLogTrace.domain.vo.FeelingComment;
import io.myLogTrace.domain.vo.WeatherComment;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Journal")
@Table(name = "JOURNAL")
public class JournalJpo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 10)
    private String date; // 날짜, 0000-00-00
    @Embedded
    private WeatherComment weatherComment; // 날씨와 코멘트
    @Embedded
    private FeelingComment feelingComment; // 감정과 코멘트
    @Column(length = 2000)
    private String contents; // 일기 내용
    private String imageId1; // 첨부 이미지1
    private String imageId2; // 첨부 이미지2
    @Column(length = 200)
    private String memo; // 메모
    private boolean saved; // 저장여부, false = 임시저장
    private boolean locked; // 잠금여부
    @CreatedDate
    private Long registeredOn; // 등록일시
    @LastModifiedDate
    private Long modifiedOn; // 변경일시

    public static List<Journal> toDomains(JPAQuery<JournalJpo> jpos) {
        //
        return jpos.stream().map(Journal::toDomain).toList();
    }
}
