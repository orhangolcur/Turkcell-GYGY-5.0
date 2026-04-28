package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID>{

}
