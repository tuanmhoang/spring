package com.tuanmhoang.spring.xml.entities;

import com.tuanmhoang.spring.xml.model.enums.Category;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
public class TicketEntity {

    private long id;

    private long eventId;

    private long userId;

    private Category category;

    private int place;

    public TicketEntity() {
    }

    public TicketEntity(long id, long eventId, long userId, Category category, int place) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.category = category;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
