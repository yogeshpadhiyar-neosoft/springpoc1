package com.neosoft.springPOC1.repository;

import com.neosoft.springPOC1.model.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEducationRepo extends JpaRepository<UserEducation,Long> {
}
