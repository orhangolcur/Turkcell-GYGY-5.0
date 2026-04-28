package com.turkcell.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, UUID>{

}
