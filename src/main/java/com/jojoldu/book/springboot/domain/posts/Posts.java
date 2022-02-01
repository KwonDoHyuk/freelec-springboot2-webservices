package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter// Getter메소드를 자동생성. Entity에서는 Setter를 생성하지 않는다. 대신 해당 필드 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야함
@NoArgsConstructor//자동 기본생성자 생성. 참고로 Entity는 기본 생성자가 필수이다.
@Entity //JPA의 어노테이션.@Entity가 붙은 클래스는 JPA가 관리하는 클래스로, 해당 클래스를 엔티티라고 한다.
public class Posts extends BaseTimeEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙. auto_increment
    private Long id;

    @Column(length = 500, nullable = false) //nullable = false : Not null,  length =500 : 500글자 초과 x
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)  //columnDefinition ="TEXT" : 컬럼의 속성을 바꿀 수 있다.
    private String content;

    private String author;

    @Builder//해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    //빌더패턴을 활용하면 어떤 필드에 어떤 인자를 넣어줬는지 명확히 알 수 있고, 넣어줄 필요 없는 필드(null)는 굳이 선언할 필요 없으니 좋다.
    //PostsRequestDto에 Builder를 활용한 toEntity() 있다.

    //일종의 setter()역할. 목적을 명확히 밝힘.
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
