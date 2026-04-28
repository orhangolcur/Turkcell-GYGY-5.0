package com.turkcell.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "penalty_records")
public class PenaltyRecord {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "amount", nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "payment_status", nullable = false, length = 20)
    private String paymentStatus; // paid, unpaid

    @Column(name = "penalty_date", nullable = false)
    private LocalDate penaltyDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "borrow_record_id", nullable = false)
    private BorrowRecord borrowRecord;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPenaltyDate() {
        return penaltyDate;
    }

    public void setPenaltyDate(LocalDate penaltyDate) {
        this.penaltyDate = penaltyDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BorrowRecord getBorrowRecord() {
        return borrowRecord;
    }

    public void setBorrowRecord(BorrowRecord borrowRecord) {
        this.borrowRecord = borrowRecord;
    }

    
}
