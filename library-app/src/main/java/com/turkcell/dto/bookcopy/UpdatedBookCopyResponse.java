package com.turkcell.dto.bookcopy;

import java.util.UUID;

public class UpdatedBookCopyResponse {
    private UUID id;
    private String barcode;
    private String status;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}