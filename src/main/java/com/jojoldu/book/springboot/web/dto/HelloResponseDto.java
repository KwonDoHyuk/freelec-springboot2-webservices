package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //Get함수 자동 생성
@RequiredArgsConstructor // 이 어노테이션은 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성. 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용
public class HelloResponseDto {
    private final String name2;
    private final int amount;
}
