package com.turkcell.dto.penaltyrecord;

import java.math.BigDecimal;
import java.util.UUID;

public class ListPenaltyRecordResponse {
    private UUID id;
    private String studentName;
    private BigDecimal amount;
    private String paymentStatus;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}