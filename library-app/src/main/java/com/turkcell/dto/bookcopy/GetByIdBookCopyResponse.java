package com.turkcell.dto.bookcopy;

import java.util.UUID;

public class GetByIdBookCopyResponse {
    private UUID id;
    private String barcode;
    private String status;
    private String bookTitle;
    private String branchName;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }
}