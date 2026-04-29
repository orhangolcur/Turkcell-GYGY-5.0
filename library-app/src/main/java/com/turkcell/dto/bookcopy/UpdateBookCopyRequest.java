package com.turkcell.dto.bookcopy;

import java.util.UUID;

public class UpdateBookCopyRequest {
    private String status;
    private UUID branchId;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public UUID getBranchId() { return branchId; }
    public void setBranchId(UUID branchId) { this.branchId = branchId; }
}