package com.turkcell.service;

import com.turkcell.dto.branch.*;
import com.turkcell.entity.Branch;
import com.turkcell.repository.BranchRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BranchServiceImpl {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public CreatedBranchResponse create(CreateBranchRequest request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());
        this.branchRepository.save(branch);

        CreatedBranchResponse response = new CreatedBranchResponse();
        response.setId(branch.getId());
        response.setName(branch.getName());
        return response;
    }

    public List<ListBranchResponse> getAll() {
        return this.branchRepository.findAll().stream().map(branch -> {
            ListBranchResponse response = new ListBranchResponse();
            response.setId(branch.getId());
            response.setName(branch.getName());
            response.setAddress(branch.getAddress());
            return response;
        }).toList();
    }

    public GetByIdBranchResponse getById(UUID id) {
        Branch branch = this.branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + id));

        GetByIdBranchResponse response = new GetByIdBranchResponse();
        response.setId(branch.getId());
        response.setName(branch.getName());
        response.setAddress(branch.getAddress());
        response.setPhone(branch.getPhone());
        response.setBookTitles(branch.getBookCopies().stream()
                .map(bookCopy -> bookCopy.getBook().getTitle())
                .distinct()
                .toList());
        return response;
    }

    public UpdatedBranchResponse update(UUID id, UpdateBranchRequest request) {
        Branch branch = this.branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + id));

        branch.setName(request.getName());
        branch.setAddress(request.getAddress());
        branch.setPhone(request.getPhone());
        this.branchRepository.save(branch);

        UpdatedBranchResponse response = new UpdatedBranchResponse();
        response.setId(branch.getId());
        response.setName(branch.getName());
        return response;
    }

    public void delete(UUID id) {
        Branch branch = this.branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found: " + id));
        this.branchRepository.delete(branch);
    }
}