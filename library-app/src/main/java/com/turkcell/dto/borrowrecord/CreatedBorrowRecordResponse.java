package com.turkcell.dto.borrowrecord;

import java.time.LocalDate;
import java.util.UUID;

public class CreatedBorrowRecordResponse {
    private UUID id;
    private String studentName;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private String status;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}