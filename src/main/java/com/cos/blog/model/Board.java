package com.cos.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; //방대한 내용 또는 html 태그와 혼합되는 내용일 경우 섬머노트 라이브러리 사용

    private int count; //조회수

    @ManyToOne // 연관관계 명시 - Many: Board, One: User
    @JoinColumn(name="userId")
    private User user;// DB는 객체를 저장할 수 없지만 ORM을 사용하여 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    // mappedBy: 연관관계의 주인이 아니며, FK(Foreign key)를 DB내에 생성하면 안될 때(1의 정규화 위배) => @JoinColumn도 필요하지 않음
    // fetch: JPA의 로딩방식으로, 즉시로딩(FetchType.EAGER)과 지연로딩(FetchType.LAZY)가 있음. @ManyToOne의 default는 EAGER, @OneToMany는 LAZY
    @JsonIgnoreProperties({"board"})
    //board 변수로의 재참조를 막아준다.
    @OrderBy("id desc")
    private List<Reply> replys;

    @CreationTimestamp
    private Timestamp createDate;
}