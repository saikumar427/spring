package com.sai.form.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.form.user.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
