package com.jojoldu.book.springboot.domain.outhuser;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserOauth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public UserOauth(String name, String email, String picture, Role role){
        this.email = email;
        this.name = name;

        this.picture = picture;
        this.role = role;
    }

    public UserOauth update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }
}
