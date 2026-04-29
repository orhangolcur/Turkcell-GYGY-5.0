package com.turkcell.service;

import com.turkcell.dto.staff.*;
import com.turkcell.entity.Staff;
import com.turkcell.repository.StaffRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class StaffServiceImpl {
    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public CreatedStaffResponse create(CreateStaffRequest request) {
        Staff staff = new Staff();
        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setRole(request.getRole());
        this.staffRepository.save(staff);

        CreatedStaffResponse response = new CreatedStaffResponse();
        response.setId(staff.getId());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());
        return response;
    }

    public List<ListStaffResponse> getAll() {
        return this.staffRepository.findAll().stream().map(staff -> {
            ListStaffResponse response = new ListStaffResponse();
            response.setId(staff.getId());
            response.setFirstName(staff.getFirstName());
            response.setLastName(staff.getLastName());
            response.setRole(staff.getRole());
            return response;
        }).toList();
    }

    public GetByIdStaffResponse getById(UUID id) {
        Staff staff = this.staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found: " + id));

        GetByIdStaffResponse response = new GetByIdStaffResponse();
        response.setId(staff.getId());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());
        response.setRole(staff.getRole());
        return response;
    }

    public UpdatedStaffResponse update(UUID id, UpdateStaffRequest request) {
        Staff staff = this.staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found: " + id));

        staff.setFirstName(request.getFirstName());
        staff.setLastName(request.getLastName());
        staff.setRole(request.getRole());
        this.staffRepository.save(staff);

        UpdatedStaffResponse response = new UpdatedStaffResponse();
        response.setId(staff.getId());
        response.setFirstName(staff.getFirstName());
        response.setLastName(staff.getLastName());
        return response;
    }

    public void delete(UUID id) {
        Staff staff = this.staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found: " + id));
        this.staffRepository.delete(staff);
    }
}