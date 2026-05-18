package com.example.noddy.notification_system.repository;

import com.example.noddy.notification_system.pojo.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
