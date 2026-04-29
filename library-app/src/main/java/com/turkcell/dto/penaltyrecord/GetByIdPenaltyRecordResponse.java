package com.turkcell.dto.penaltyrecord;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class GetByIdPenaltyRecordResponse {
    private UUID id;
    private String studentName;
    private String bookTitle;
    private BigDecimal amount;
    private String paymentStatus;
    private LocalDate penaltyDate;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public LocalDate getPenaltyDate() { return penaltyDate; }
    public void setPenaltyDate(LocalDate penaltyDate) { this.penaltyDate = penaltyDate; }
}