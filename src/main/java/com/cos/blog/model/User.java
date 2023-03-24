package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM - C++, Java, Python 등 여러 언어로 만들어진 객체들을 테이블로 매핑해주는 툴

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // User 클래스를 MySQL의 row로 변환해줌
// @DynamicInsert // User.role은 디폴트 값이 정해져있기 떄문에 null의 값이 입력되면 안됨. => @DynamicInsert: INSERT 할때 null인 필드 모두 제외시켜줌
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 시퀀스, AUTO_INCREMENT

    @Column(nullable = false, length=100, unique = true)
    private String username; //아이디, non-null

    @Column(nullable = false, length=100) // 해쉬를 통한 암호화 전략 -> 큰 length
    private String password;

    @Column(nullable = false, length=50)
    private String email;

//    @ColumnDefault(" 'user' ")
    @Enumerated(EnumType.STRING) // DB는 RoleType이 없으므로 String으로 변환해서 넣어줌
    private RoleType role; // ADMIN, USER
    
    private String oauth;

    @CreationTimestamp
    private Timestamp createDate;

}