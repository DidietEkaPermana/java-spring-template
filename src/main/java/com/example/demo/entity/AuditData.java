package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuditData {
    private Date CreatedDate;
    private String CreatedBy;
    private Date LastUpdateDate;
    private String LastUpdateBy;
}
