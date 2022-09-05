package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "generate_date")
    private Long generateDate;
}