package com.turkcell.dto.branch;

import java.util.List;
import java.util.UUID;

public class GetByIdBranchResponse {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private List<String> bookTitles;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public List<String> getBookTitles() { return bookTitles; }
    public void setBookTitles(List<String> bookTitles) { this.bookTitles = bookTitles; }
}