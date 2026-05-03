package com.turkcell.library_cqrs_app.application.features.branch.query.getbyid;

import org.springframework.stereotype.Component;

import com.turkcell.library_cqrs_app.core.exception.NotFoundException;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.BranchRepository;

@Component
public class GetByIdBranchQueryHandler implements QueryHandler<GetByIdBranchQuery, GetByIdBranchResponse>{

    private final BranchRepository branchRepository;

    public GetByIdBranchQueryHandler(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public GetByIdBranchResponse handle(GetByIdBranchQuery query) {
        return branchRepository.findById(query.id())
            .map(branch -> new GetByIdBranchResponse(
                branch.getId(),
                branch.getName(),
                branch.getAddress(),
                branch.getPhone()
            ))
            .orElseThrow(() -> new NotFoundException("Şube bulunamadı."));
    }

}
