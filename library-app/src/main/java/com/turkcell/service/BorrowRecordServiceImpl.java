package com.turkcell.service;

import com.turkcell.dto.borrowrecord.*;
import com.turkcell.entity.Book;
import com.turkcell.entity.BorrowRecord;
import com.turkcell.entity.Student;
import com.turkcell.repository.BookRepository;
import com.turkcell.repository.BorrowRecordRepository;
import com.turkcell.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowRecordServiceImpl {
    private final BorrowRecordRepository borrowRecordRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    public CreatedBorrowRecordResponse create(CreateBorrowRecordRequest request) {
        Student student = this.studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found: " + request.getStudentId()));

        Book book = this.bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found: " + request.getBookId()));

        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setStudent(student);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(LocalDate.now());
        borrowRecord.setDueDate(request.getDueDate());
        borrowRecord.setStatus("active");
        this.borrowRecordRepository.save(borrowRecord);

        CreatedBorrowRecordResponse response = new CreatedBorrowRecordResponse();
        response.setId(borrowRecord.getId());
        response.setStudentName(student.getFirstName() + " " + student.getLastName());
        response.setBookTitle(book.getTitle());
        response.setBorrowDate(borrowRecord.getBorrowDate());
        response.setDueDate(borrowRecord.getDueDate());
        response.setStatus(borrowRecord.getStatus());
        return response;
    }

    public List<ListBorrowRecordResponse> getAll() {
        return this.borrowRecordRepository.findAll().stream().map(borrowRecord -> {
            ListBorrowRecordResponse response = new ListBorrowRecordResponse();
            response.setId(borrowRecord.getId());
            response.setStudentName(borrowRecord.getStudent().getFirstName() + " " + borrowRecord.getStudent().getLastName());
            response.setBookTitle(borrowRecord.getBook().getTitle());
            response.setStatus(borrowRecord.getStatus());
            return response;
        }).toList();
    }

    public GetByIdBorrowRecordResponse getById(UUID id) {
        BorrowRecord borrowRecord = this.borrowRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BorrowRecord not found: " + id));

        GetByIdBorrowRecordResponse response = new GetByIdBorrowRecordResponse();
        response.setId(borrowRecord.getId());
        response.setStudentName(borrowRecord.getStudent().getFirstName() + " " + borrowRecord.getStudent().getLastName());
        response.setBookTitle(borrowRecord.getBook().getTitle());
        response.setBorrowDate(borrowRecord.getBorrowDate());
        response.setDueDate(borrowRecord.getDueDate());
        response.setReturnDate(borrowRecord.getReturnDate());
        response.setStatus(borrowRecord.getStatus());
        return response;
    }
}