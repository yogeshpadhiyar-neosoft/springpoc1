package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserContracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContractsRepo extends JpaRepository<UserContracts,Long> {
}
