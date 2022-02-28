package com.tuanmhoang.spring.xml.entities;

import com.tuanmhoang.spring.xml.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {

    private long id;

    private long eventId;

    private long userId;

    private Category category;

    private int place;
}
