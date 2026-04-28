package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.entity.PenaltyRecord;

@Repository
public interface PenaltyRecordRepository extends JpaRepository<PenaltyRecord, UUID>{

}
