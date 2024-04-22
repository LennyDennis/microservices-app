package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @Column(updatable = false)
    public LocalDate createdAt;

    @Column(updatable = false)
    public String createdBy;

    @Column(insertable = false)
    public LocalDate updatedAt;

    @Column(insertable = false)
    public String updatedBy;
}
