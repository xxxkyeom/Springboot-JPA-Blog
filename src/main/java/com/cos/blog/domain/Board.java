package com.cos.blog.domain;

import com.cos.blog.domain.Base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터 에너테이션
    private String content;

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // 연관 관계의 주인이 아니니 컬럼을 만들지 말아달라, 단순 참고용
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> replies = new ArrayList<>();

    // jpa에서는 직접 값 대입할 필요 없이 join 쿼리에 의해 List로 지정된 컬럼들의 값이 갱신된다
}
