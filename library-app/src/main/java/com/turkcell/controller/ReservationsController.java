package com.turkcell.controller;

import com.turkcell.dto.reservation.*;
import com.turkcell.service.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {
    private final ReservationServiceImpl reservationService;

    public ReservationsController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public CreatedReservationResponse create(@RequestBody CreateReservationRequest request) {
        return this.reservationService.create(request);
    }

    @GetMapping
    public List<ListReservationResponse> getAll() {
        return this.reservationService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdReservationResponse getById(@PathVariable UUID id) {
        return this.reservationService.getById(id);
    }

    @PutMapping("/{id}")
    public UpdatedReservationResponse update(@PathVariable UUID id, @RequestBody UpdateReservationRequest request) {
        return this.reservationService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.reservationService.delete(id);
    }
}