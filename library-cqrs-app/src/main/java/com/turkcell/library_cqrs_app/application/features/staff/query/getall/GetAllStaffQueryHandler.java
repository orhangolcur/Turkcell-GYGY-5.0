package com.turkcell.library_cqrs_app.application.features.staff.query.getall;

import com.turkcell.library_cqrs_app.core.mediator.cqrs.QueryHandler;
import com.turkcell.library_cqrs_app.persistence.repository.StaffRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GetAllStaffQueryHandler implements QueryHandler<GetAllStaffQuery, List<GetAllStaffResponse>> {

    private final StaffRepository staffRepository;

    public GetAllStaffQueryHandler(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<GetAllStaffResponse> handle(GetAllStaffQuery query) {
        return staffRepository.findAll().stream()
            .map(staff -> new GetAllStaffResponse(
                staff.getId(),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getRole()
            ))
            .toList();
    }
}