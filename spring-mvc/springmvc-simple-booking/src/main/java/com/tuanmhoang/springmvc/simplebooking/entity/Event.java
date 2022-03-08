package com.tuanmhoang.springmvc.simplebooking.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_event")
public class Event {
    @Id
    private Long id;

    private String title;

    @Column(name = "event_date")
    private LocalDate date;
}
