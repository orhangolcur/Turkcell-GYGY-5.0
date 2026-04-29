package com.turkcell.dto.book;

import java.util.Set;
import java.util.UUID;

public class GetByIdBookResponse {
    private UUID id;
    private String isbn;
    private String title;
    private int publishYear;
    private int stock;
    private String categoryName;
    private Set<String> authorNames;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getPublishYear() { return publishYear; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public Set<String> getAuthorNames() { return authorNames; }
    public void setAuthorNames(Set<String> authorNames) { this.authorNames = authorNames; }
}