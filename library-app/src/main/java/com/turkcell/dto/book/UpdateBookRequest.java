package com.turkcell.dto.book;

import java.util.UUID;

public class UpdateBookRequest {
    private String isbn;
    private String title;
    private int publishYear;
    private int stock;
    private UUID categoryId;

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPublishYear() { return publishYear; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public UUID getCategoryId() { return categoryId; }
    public void setCategoryId(UUID categoryId) { this.categoryId = categoryId; }
}