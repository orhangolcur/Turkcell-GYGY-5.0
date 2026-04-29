package com.turkcell.service;

import com.turkcell.dto.returnrecord.*;
import com.turkcell.entity.BorrowRecord;
import com.turkcell.entity.ReturnRecord;
import com.turkcell.entity.Staff;
import com.turkcell.repository.BorrowRecordRepository;
import com.turkcell.repository.ReturnRecordRepository;
import com.turkcell.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReturnRecordServiceImpl {
    private final ReturnRecordRepository returnRecordRepository;
    private final BorrowRecordRepository borrowRecordRepository;
    private final StaffRepository staffRepository;

    public ReturnRecordServiceImpl(ReturnRecordRepository returnRecordRepository, BorrowRecordRepository borrowRecordRepository, StaffRepository staffRepository) {
        this.returnRecordRepository = returnRecordRepository;
        this.borrowRecordRepository = borrowRecordRepository;
        this.staffRepository = staffRepository;
    }

    public CreatedReturnRecordResponse create(CreateReturnRecordRequest request) {
        BorrowRecord borrowRecord = this.borrowRecordRepository.findById(request.getBorrowRecordId())
                .orElseThrow(() -> new RuntimeException("BorrowRecord not found: " + request.getBorrowRecordId()));

        Staff staff = this.staffRepository.findById(request.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found: " + request.getStaffId()));

        ReturnRecord returnRecord = new ReturnRecord();
        returnRecord.setBorrowRecord(borrowRecord);
        returnRecord.setStaff(staff);
        returnRecord.setBookCondition(request.getBookCondition());
        returnRecord.setReturnDate(LocalDate.now());
        this.returnRecordRepository.save(returnRecord);

        // BorrowRecord'un statusunu güncelle
        borrowRecord.setStatus("returned");
        borrowRecord.setReturnDate(LocalDate.now());
        this.borrowRecordRepository.save(borrowRecord);

        CreatedReturnRecordResponse response = new CreatedReturnRecordResponse();
        response.setId(returnRecord.getId());
        response.setStudentName(borrowRecord.getStudent().getFirstName() + " " + borrowRecord.getStudent().getLastName());
        response.setBookTitle(borrowRecord.getBook().getTitle());
        response.setReturnDate(returnRecord.getReturnDate());
        response.setBookCondition(returnRecord.getBookCondition());
        return response;
    }

    public List<ListReturnRecordResponse> getAll() {
        return this.returnRecordRepository.findAll().stream().map(returnRecord -> {
            ListReturnRecordResponse response = new ListReturnRecordResponse();
            response.setId(returnRecord.getId());
            response.setStudentName(returnRecord.getBorrowRecord().getStudent().getFirstName() + " " + returnRecord.getBorrowRecord().getStudent().getLastName());
            response.setBookTitle(returnRecord.getBorrowRecord().getBook().getTitle());
            response.setReturnDate(returnRecord.getReturnDate());
            return response;
        }).toList();
    }

    public GetByIdReturnRecordResponse getById(UUID id) {
        ReturnRecord returnRecord = this.returnRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ReturnRecord not found: " + id));

        GetByIdReturnRecordResponse response = new GetByIdReturnRecordResponse();
        response.setId(returnRecord.getId());
        response.setStudentName(returnRecord.getBorrowRecord().getStudent().getFirstName() + " " + returnRecord.getBorrowRecord().getStudent().getLastName());
        response.setBookTitle(returnRecord.getBorrowRecord().getBook().getTitle());
        response.setReturnDate(returnRecord.getReturnDate());
        response.setBookCondition(returnRecord.getBookCondition());
        response.setStaffName(returnRecord.getStaff().getFirstName() + " " + returnRecord.getStaff().getLastName());
        return response;
    }
}