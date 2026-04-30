package com.turkcell.library_cqrs_app.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn; // International Standard Book Number(her kitaba özgü)

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "publish_year")
    private int publishYear;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(
        name = "book_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getPublishYear() { return publishYear; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Set<Author> getAuthors() { return authors; }
    public void setAuthors(Set<Author> authors) { this.authors = authors; }
}