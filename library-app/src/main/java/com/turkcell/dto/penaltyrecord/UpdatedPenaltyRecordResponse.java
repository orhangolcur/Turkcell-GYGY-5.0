package com.turkcell.dto.penaltyrecord;

import java.util.UUID;

public class UpdatedPenaltyRecordResponse {
    private UUID id;
    private String paymentStatus;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}