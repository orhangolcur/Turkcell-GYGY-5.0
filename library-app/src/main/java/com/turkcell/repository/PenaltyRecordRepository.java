package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.entity.PenaltyRecord;

public interface PenaltyRecordRepository extends JpaRepository<PenaltyRecord, UUID>{

}
