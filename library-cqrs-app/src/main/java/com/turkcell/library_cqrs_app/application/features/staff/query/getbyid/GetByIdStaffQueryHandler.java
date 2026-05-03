package com.turkcell.library_cqrs_app.application.features.staff.query.getbyid;

import com.turkcell.library_cqrs_app.core.exception.NotFoundException;
import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.StaffRepository;
import org.springframework.stereotype.Component;

@Component
public class GetByIdStaffQueryHandler implements QueryHandler<GetByIdStaffQuery, GetByIdStaffResponse> {

    private final StaffRepository staffRepository;

    public GetByIdStaffQueryHandler(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public GetByIdStaffResponse handle(GetByIdStaffQuery query) {
        return staffRepository.findById(query.id())
            .map(staff -> new GetByIdStaffResponse(
                staff.getId(),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getRole()
            ))
            .orElseThrow(() -> new NotFoundException("Görevli bulunamadı."));
    }
}
