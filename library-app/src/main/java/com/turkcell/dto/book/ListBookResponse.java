package com.turkcell.dto.book;

import java.util.UUID;

public class ListBookResponse {
    private UUID id;
    private String title;
    private String categoryName;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}