package com.turkcell.service;

import com.turkcell.dto.book.*;
import com.turkcell.entity.Author;
import com.turkcell.entity.Book;
import com.turkcell.entity.Category;
import com.turkcell.repository.AuthorRepository;
import com.turkcell.repository.BookRepository;
import com.turkcell.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    public CreatedBookResponse create(CreateBookRequest request) {
        Category category = this.categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found: " + request.getCategoryId()));

        Set<Author> authors = request.getAuthorIds().stream()
                .map(authorId -> this.authorRepository.findById(authorId)
                        .orElseThrow(() -> new RuntimeException("Author not found: " + authorId)))
                .collect(Collectors.toSet());

        Book book = new Book();
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setPublishYear(request.getPublishYear());
        book.setStock(request.getStock());
        book.setCategory(category);
        book.setAuthors(authors);
        this.bookRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        return response;
    }

    public List<ListBookResponse> getAll() {
        return this.bookRepository.findAll().stream().map(book -> {
            ListBookResponse response = new ListBookResponse();
            response.setId(book.getId());
            response.setTitle(book.getTitle());
            response.setCategoryName(book.getCategory().getName());
            return response;
        }).toList();
    }

    public GetByIdBookResponse getById(UUID id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found: " + id));

        GetByIdBookResponse response = new GetByIdBookResponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setPublishYear(book.getPublishYear());
        response.setStock(book.getStock());
        response.setCategoryName(book.getCategory().getName());
        response.setAuthorNames(book.getAuthors().stream()
                .map(author -> author.getFirstName() + " " + author.getLastName())
                .collect(Collectors.toSet()));
        return response;
    }

    public UpdatedBookResponse update(UUID id, UpdateBookRequest request) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found: " + id));

        Category category = this.categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found: " + request.getCategoryId()));

        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setPublishYear(request.getPublishYear());
        book.setStock(request.getStock());
        book.setCategory(category);
        this.bookRepository.save(book);

        UpdatedBookResponse response = new UpdatedBookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        return response;
    }

    public void delete(UUID id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found: " + id));
        this.bookRepository.delete(book);
    }
}