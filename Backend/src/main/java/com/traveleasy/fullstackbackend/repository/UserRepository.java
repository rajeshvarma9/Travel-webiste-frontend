package com.traveleasy.fullstackbackend.repository;

import com.traveleasy.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);

    User findByEmail(String email);


}
