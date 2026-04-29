package com.turkcell.dto.borrowrecord;

import java.time.LocalDate;
import java.util.UUID;

public class CreateBorrowRecordRequest {
    private UUID studentId;
    private UUID bookId;
    private LocalDate dueDate;

    public UUID getStudentId() { return studentId; }
    public void setStudentId(UUID studentId) { this.studentId = studentId; }
    public UUID getBookId() { return bookId; }
    public void setBookId(UUID bookId) { this.bookId = bookId; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}