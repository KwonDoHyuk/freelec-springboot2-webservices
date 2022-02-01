package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//보통 DAO라고 불리는 DB Layer 접근자. JPA에서는 Repository라고 부르며 인터페이스로 생성.
//JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됩니다.
//Entity클래스와 Repository는 같이 위치해있어야 연관됩니다.
public interface PostsRepository extends JpaRepository <Posts, Long>{


    //SpringDataJpa에서 제공하지 않는 메소드는 직접 작성해야함
    @Query("Select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();


}
