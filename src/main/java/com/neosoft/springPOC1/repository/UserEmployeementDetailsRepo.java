package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserEmployeementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmployeementDetailsRepo extends JpaRepository<UserEmployeementDetails,Long> {
}
