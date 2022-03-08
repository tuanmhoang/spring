package com.tuanmhoang.springmvc.simplebooking.repository;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    List<Event> findByTitle(String title);

    List<Event> findByDate(Date day);
}
