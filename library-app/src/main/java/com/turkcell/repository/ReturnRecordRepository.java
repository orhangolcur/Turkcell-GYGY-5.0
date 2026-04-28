package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.entity.ReturnRecord;

public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, UUID>{

}
