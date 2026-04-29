package com.turkcell.service;

import com.turkcell.dto.reservation.*;
import com.turkcell.entity.Book;
import com.turkcell.entity.Reservation;
import com.turkcell.entity.Student;
import com.turkcell.repository.BookRepository;
import com.turkcell.repository.ReservationRepository;
import com.turkcell.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl {
    private final ReservationRepository reservationRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    public CreatedReservationResponse create(CreateReservationRequest request) {
        Student student = this.studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found: " + request.getStudentId()));

        Book book = this.bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found: " + request.getBookId()));

        Reservation reservation = new Reservation();
        reservation.setStudent(student);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDate.now());
        reservation.setStatus("pending");
        this.reservationRepository.save(reservation);

        CreatedReservationResponse response = new CreatedReservationResponse();
        response.setId(reservation.getId());
        response.setStudentName(student.getFirstName() + " " + student.getLastName());
        response.setBookTitle(book.getTitle());
        response.setReservationDate(reservation.getReservationDate());
        response.setStatus(reservation.getStatus());
        return response;
    }

    public List<ListReservationResponse> getAll() {
        return this.reservationRepository.findAll().stream().map(reservation -> {
            ListReservationResponse response = new ListReservationResponse();
            response.setId(reservation.getId());
            response.setStudentName(reservation.getStudent().getFirstName() + " " + reservation.getStudent().getLastName());
            response.setBookTitle(reservation.getBook().getTitle());
            response.setStatus(reservation.getStatus());
            return response;
        }).toList();
    }

    public GetByIdReservationResponse getById(UUID id) {
        Reservation reservation = this.reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + id));

        GetByIdReservationResponse response = new GetByIdReservationResponse();
        response.setId(reservation.getId());
        response.setStudentName(reservation.getStudent().getFirstName() + " " + reservation.getStudent().getLastName());
        response.setBookTitle(reservation.getBook().getTitle());
        response.setReservationDate(reservation.getReservationDate());
        response.setStatus(reservation.getStatus());
        return response;
    }

    public UpdatedReservationResponse update(UUID id, UpdateReservationRequest request) {
        Reservation reservation = this.reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + id));

        reservation.setStatus(request.getStatus());
        this.reservationRepository.save(reservation);

        UpdatedReservationResponse response = new UpdatedReservationResponse();
        response.setId(reservation.getId());
        response.setStatus(reservation.getStatus());
        return response;
    }

    public void delete(UUID id) {
        Reservation reservation = this.reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + id));
        this.reservationRepository.delete(reservation);
    }
}