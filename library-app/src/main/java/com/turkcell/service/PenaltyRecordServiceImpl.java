package com.turkcell.service;

import com.turkcell.dto.penaltyrecord.*;
import com.turkcell.entity.BorrowRecord;
import com.turkcell.entity.PenaltyRecord;
import com.turkcell.entity.Student;
import com.turkcell.repository.BorrowRecordRepository;
import com.turkcell.repository.PenaltyRecordRepository;
import com.turkcell.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PenaltyRecordServiceImpl {
    private final PenaltyRecordRepository penaltyRecordRepository;
    private final StudentRepository studentRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public PenaltyRecordServiceImpl(PenaltyRecordRepository penaltyRecordRepository, StudentRepository studentRepository, BorrowRecordRepository borrowRecordRepository) {
        this.penaltyRecordRepository = penaltyRecordRepository;
        this.studentRepository = studentRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public CreatedPenaltyRecordResponse create(CreatePenaltyRecordRequest request) {
        Student student = this.studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found: " + request.getStudentId()));

        BorrowRecord borrowRecord = this.borrowRecordRepository.findById(request.getBorrowRecordId())
                .orElseThrow(() -> new RuntimeException("BorrowRecord not found: " + request.getBorrowRecordId()));

        PenaltyRecord penaltyRecord = new PenaltyRecord();
        penaltyRecord.setStudent(student);
        penaltyRecord.setBorrowRecord(borrowRecord);
        penaltyRecord.setAmount(request.getAmount());
        penaltyRecord.setPaymentStatus("unpaid");
        penaltyRecord.setPenaltyDate(LocalDate.now());
        this.penaltyRecordRepository.save(penaltyRecord);

        CreatedPenaltyRecordResponse response = new CreatedPenaltyRecordResponse();
        response.setId(penaltyRecord.getId());
        response.setStudentName(student.getFirstName() + " " + student.getLastName());
        response.setAmount(penaltyRecord.getAmount());
        response.setPaymentStatus(penaltyRecord.getPaymentStatus());
        response.setPenaltyDate(penaltyRecord.getPenaltyDate());
        return response;
    }

    public List<ListPenaltyRecordResponse> getAll() {
        return this.penaltyRecordRepository.findAll().stream().map(penaltyRecord -> {
            ListPenaltyRecordResponse response = new ListPenaltyRecordResponse();
            response.setId(penaltyRecord.getId());
            response.setStudentName(penaltyRecord.getStudent().getFirstName() + " " + penaltyRecord.getStudent().getLastName());
            response.setAmount(penaltyRecord.getAmount());
            response.setPaymentStatus(penaltyRecord.getPaymentStatus());
            return response;
        }).toList();
    }

    public GetByIdPenaltyRecordResponse getById(UUID id) {
        PenaltyRecord penaltyRecord = this.penaltyRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PenaltyRecord not found: " + id));

        GetByIdPenaltyRecordResponse response = new GetByIdPenaltyRecordResponse();
        response.setId(penaltyRecord.getId());
        response.setStudentName(penaltyRecord.getStudent().getFirstName() + " " + penaltyRecord.getStudent().getLastName());
        response.setBookTitle(penaltyRecord.getBorrowRecord().getBook().getTitle());
        response.setAmount(penaltyRecord.getAmount());
        response.setPaymentStatus(penaltyRecord.getPaymentStatus());
        response.setPenaltyDate(penaltyRecord.getPenaltyDate());
        return response;
    }

    public UpdatedPenaltyRecordResponse update(UUID id, UpdatePenaltyRecordRequest request) {
        PenaltyRecord penaltyRecord = this.penaltyRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PenaltyRecord not found: " + id));

        penaltyRecord.setPaymentStatus(request.getPaymentStatus());
        this.penaltyRecordRepository.save(penaltyRecord);

        UpdatedPenaltyRecordResponse response = new UpdatedPenaltyRecordResponse();
        response.setId(penaltyRecord.getId());
        response.setPaymentStatus(penaltyRecord.getPaymentStatus());
        return response;
    }
}