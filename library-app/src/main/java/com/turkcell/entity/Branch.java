package com.turkcell.entity;

import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

    @OneToMany(mappedBy = "branch")
    private List<BookCopy> bookCopies;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopy> bookCopies) {
        this.bookCopies = bookCopies;
    }

    
    
}
