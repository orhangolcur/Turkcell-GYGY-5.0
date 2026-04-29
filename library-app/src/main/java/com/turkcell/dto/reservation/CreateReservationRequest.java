package com.turkcell.dto.reservation;

import java.util.UUID;

public class CreateReservationRequest {
    private UUID studentId;
    private UUID bookId;

    public UUID getStudentId() { return studentId; }
    public void setStudentId(UUID studentId) { this.studentId = studentId; }
    public UUID getBookId() { return bookId; }
    public void setBookId(UUID bookId) { this.bookId = bookId; }
}