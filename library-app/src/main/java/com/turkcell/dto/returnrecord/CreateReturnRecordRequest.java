package com.turkcell.dto.returnrecord;

import java.util.UUID;

public class CreateReturnRecordRequest {
    private UUID borrowRecordId;
    private UUID staffId;
    private String bookCondition;

    public UUID getBorrowRecordId() { return borrowRecordId; }
    public void setBorrowRecordId(UUID borrowRecordId) { this.borrowRecordId = borrowRecordId; }
    public UUID getStaffId() { return staffId; }
    public void setStaffId(UUID staffId) { this.staffId = staffId; }
    public String getBookCondition() { return bookCondition; }
    public void setBookCondition(String bookCondition) { this.bookCondition = bookCondition; }
}