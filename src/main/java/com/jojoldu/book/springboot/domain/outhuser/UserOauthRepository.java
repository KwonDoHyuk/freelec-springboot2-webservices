package com.jojoldu.book.springboot.domain.outhuser;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOauthRepository extends JpaRepository<UserOauth, Long> {

    Optional<UserOauth> findByEmail(String email);

}
