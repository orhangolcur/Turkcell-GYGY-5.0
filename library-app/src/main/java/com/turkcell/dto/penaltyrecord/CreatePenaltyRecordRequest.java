package com.turkcell.dto.penaltyrecord;

import java.math.BigDecimal;
import java.util.UUID;

public class CreatePenaltyRecordRequest {
    private UUID studentId;
    private UUID borrowRecordId;
    private BigDecimal amount;

    public UUID getStudentId() { return studentId; }
    public void setStudentId(UUID studentId) { this.studentId = studentId; }
    public UUID getBorrowRecordId() { return borrowRecordId; }
    public void setBorrowRecordId(UUID borrowRecordId) { this.borrowRecordId = borrowRecordId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}