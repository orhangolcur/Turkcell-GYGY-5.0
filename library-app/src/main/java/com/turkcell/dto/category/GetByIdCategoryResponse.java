package com.turkcell.dto.category;

import java.util.List;
import java.util.UUID;

public class GetByIdCategoryResponse {
    private UUID id;
    private String name;
    private String description;
    private List<String> bookTitles;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<String> getBookTitles() { return bookTitles; }
    public void setBookTitles(List<String> bookTitles) { this.bookTitles = bookTitles; }
}