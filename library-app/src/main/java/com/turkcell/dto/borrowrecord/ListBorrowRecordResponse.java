package com.turkcell.dto.borrowrecord;

import java.util.UUID;

public class ListBorrowRecordResponse {
    private UUID id;
    private String studentName;
    private String bookTitle;
    private String status;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}