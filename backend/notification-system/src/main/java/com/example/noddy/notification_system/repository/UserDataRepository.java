package com.example.noddy.notification_system.repository;

import com.example.noddy.notification_system.pojo.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUsername(String username);   // getting the user details by the username
    boolean existByUserName(String username);
}
