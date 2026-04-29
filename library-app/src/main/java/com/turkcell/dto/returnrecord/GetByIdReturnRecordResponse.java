package com.turkcell.dto.returnrecord;

import java.time.LocalDate;
import java.util.UUID;

public class GetByIdReturnRecordResponse {
    private UUID id;
    private String studentName;
    private String bookTitle;
    private LocalDate returnDate;
    private String bookCondition;
    private String staffName;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getBookCondition() { return bookCondition; }
    public void setBookCondition(String bookCondition) { this.bookCondition = bookCondition; }
    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }
}