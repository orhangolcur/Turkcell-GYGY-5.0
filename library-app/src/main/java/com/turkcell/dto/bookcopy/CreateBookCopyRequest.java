package com.turkcell.dto.bookcopy;

import java.util.UUID;

public class CreateBookCopyRequest {
    private String barcode;
    private String status;
    private UUID bookId;
    private UUID branchId;

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public UUID getBookId() { return bookId; }
    public void setBookId(UUID bookId) { this.bookId = bookId; }
    public UUID getBranchId() { return branchId; }
    public void setBranchId(UUID branchId) { this.branchId = branchId; }
}