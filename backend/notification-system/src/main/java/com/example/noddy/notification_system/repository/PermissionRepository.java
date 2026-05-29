package com.example.noddy.notification_system.repository;

import com.example.noddy.notification_system.pojo.PermissionsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionsData, Long> {

    Optional<PermissionsData> findPermissionByPermissionName(String permissionName);
}
