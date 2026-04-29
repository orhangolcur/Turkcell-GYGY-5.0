package com.turkcell.dto.author;

import java.util.List;
import java.util.UUID;

public class GetByIdAuthorResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private List<String> bookTitles;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public List<String> getBookTitles() { return bookTitles; }
    public void setBookTitles(List<String> bookTitles) { this.bookTitles = bookTitles; }
}