package com.turkcell.dto.bookcopy;

import java.util.UUID;

public class CreatedBookCopyResponse {
    private UUID id;
    private String barcode;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
}