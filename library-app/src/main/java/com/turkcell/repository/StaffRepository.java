package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, UUID>{

}
