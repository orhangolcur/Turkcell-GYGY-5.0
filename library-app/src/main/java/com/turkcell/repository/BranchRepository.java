package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, UUID>{

}
