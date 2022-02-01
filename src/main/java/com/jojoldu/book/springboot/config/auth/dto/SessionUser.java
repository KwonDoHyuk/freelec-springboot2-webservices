package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.outhuser.UserOauth;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
    //객체의 직렬화는 객체의 내용을 바이트 단위로 변환하여 파일 또는 네트워크를 통해서 스트림(송수신)이 가능하도록 하는 것을 의미한다.

    //add
    public SessionUser(UserOauth userOauth) {
        this.name = userOauth.getName();
        this.email = userOauth.getEmail();
        this.picture = userOauth.getPicture();
    }
}