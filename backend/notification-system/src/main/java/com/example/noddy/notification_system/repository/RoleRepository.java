package com.example.noddy.notification_system.repository;

import com.example.noddy.notification_system.constants.RoleConstants;
import com.example.noddy.notification_system.pojo.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleData, Long> {

    @Query("SELECT r.id FROM RoleData r WHERE r.roleName = :roleName")
    Long getRoleIdByRoleName(
            @Param("roleName") RoleConstants roleName
    );

    Optional<RoleData> findByRoleName(String roleName);
}
