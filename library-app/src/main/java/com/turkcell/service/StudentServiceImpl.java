package com.turkcell.service;

import com.turkcell.dto.student.*;
import com.turkcell.entity.Student;
import com.turkcell.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreatedStudentResponse create(CreateStudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setMembershipDate(LocalDate.now());
        this.studentRepository.save(student);

        CreatedStudentResponse response = new CreatedStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        return response;
    }

    public List<ListStudentResponse> getAll() {
        return this.studentRepository.findAll().stream().map(student -> {
            ListStudentResponse response = new ListStudentResponse();
            response.setId(student.getId());
            response.setFirstName(student.getFirstName());
            response.setLastName(student.getLastName());
            response.setEmail(student.getEmail());
            return response;
        }).toList();
    }

    public GetByIdStudentResponse getById(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));

        GetByIdStudentResponse response = new GetByIdStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPhone(student.getPhone());
        response.setMembershipDate(student.getMembershipDate());
        return response;
    }

    public UpdatedStudentResponse update(UUID id, UpdateStudentRequest request) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        this.studentRepository.save(student);

        UpdatedStudentResponse response = new UpdatedStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        return response;
    }

    public void delete(UUID id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
        this.studentRepository.delete(student);
    }
}