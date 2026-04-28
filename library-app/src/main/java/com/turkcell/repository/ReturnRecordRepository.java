package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.entity.ReturnRecord;

@Repository
public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, UUID>{

}
