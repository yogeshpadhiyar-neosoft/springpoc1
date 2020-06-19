package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Long> {
}
