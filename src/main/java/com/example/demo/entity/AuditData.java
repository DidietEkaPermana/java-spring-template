package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AuditData {
    @Column(name = "createdDate", nullable = false)
    private Date CreatedDate;

    @Column(name = "createdBy", nullable = false)
    private String CreatedBy;

    @Column(name = "lastUpdateDate", nullable = false)
    private Date LastUpdateDate;

    @Column(name = "lastUpdateBy", nullable = false)
    private String LastUpdateBy;
}
