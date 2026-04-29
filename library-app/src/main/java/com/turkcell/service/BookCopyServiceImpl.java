package com.turkcell.service;

import com.turkcell.dto.bookcopy.*;
import com.turkcell.entity.Book;
import com.turkcell.entity.BookCopy;
import com.turkcell.entity.Branch;
import com.turkcell.repository.BookCopyRepository;
import com.turkcell.repository.BookRepository;
import com.turkcell.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookCopyServiceImpl {
    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final BranchRepository branchRepository;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookRepository bookRepository, BranchRepository branchRepository) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookRepository = bookRepository;
        this.branchRepository = branchRepository;
    }

    public CreatedBookCopyResponse create(CreateBookCopyRequest request) {
        Book book = this.bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found: " + request.getBookId()));

        Branch branch = this.branchRepository.findById(request.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found: " + request.getBranchId()));

        BookCopy bookCopy = new BookCopy();
        bookCopy.setBarcode(request.getBarcode());
        bookCopy.setStatus(request.getStatus());
        bookCopy.setBook(book);
        bookCopy.setBranch(branch);
        this.bookCopyRepository.save(bookCopy);

        CreatedBookCopyResponse response = new CreatedBookCopyResponse();
        response.setId(bookCopy.getId());
        response.setBarcode(bookCopy.getBarcode());
        return response;
    }

    public List<ListBookCopyResponse> getAll() {
        return this.bookCopyRepository.findAll().stream().map(bookCopy -> {
            ListBookCopyResponse response = new ListBookCopyResponse();
            response.setId(bookCopy.getId());
            response.setBarcode(bookCopy.getBarcode());
            response.setStatus(bookCopy.getStatus());
            response.setBookTitle(bookCopy.getBook().getTitle());
            response.setBranchName(bookCopy.getBranch().getName());
            return response;
        }).toList();
    }

    public GetByIdBookCopyResponse getById(UUID id) {
        BookCopy bookCopy = this.bookCopyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookCopy not found: " + id));

        GetByIdBookCopyResponse response = new GetByIdBookCopyResponse();
        response.setId(bookCopy.getId());
        response.setBarcode(bookCopy.getBarcode());
        response.setStatus(bookCopy.getStatus());
        response.setBookTitle(bookCopy.getBook().getTitle());
        response.setBranchName(bookCopy.getBranch().getName());
        return response;
    }

    public UpdatedBookCopyResponse update(UUID id, UpdateBookCopyRequest request) {
        BookCopy bookCopy = this.bookCopyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookCopy not found: " + id));

        Branch branch = this.branchRepository.findById(request.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found: " + request.getBranchId()));

        bookCopy.setStatus(request.getStatus());
        bookCopy.setBranch(branch);
        this.bookCopyRepository.save(bookCopy);

        UpdatedBookCopyResponse response = new UpdatedBookCopyResponse();
        response.setId(bookCopy.getId());
        response.setBarcode(bookCopy.getBarcode());
        response.setStatus(bookCopy.getStatus());
        return response;
    }

    public void delete(UUID id) {
        BookCopy bookCopy = this.bookCopyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookCopy not found: " + id));
        this.bookCopyRepository.delete(bookCopy);
    }
}