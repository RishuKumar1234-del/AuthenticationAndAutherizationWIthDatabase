package com.security.securitywithver3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.securitywithver3.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByName(String username);

}
