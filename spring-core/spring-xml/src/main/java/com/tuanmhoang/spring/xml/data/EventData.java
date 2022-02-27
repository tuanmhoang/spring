package com.tuanmhoang.spring.xml.data;

import com.tuanmhoang.spring.xml.entities.EventEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventData {
    private Map<Long, EventEntity> eventData = new HashMap<>();

    public void init() throws ParseException {
        eventData.put(1L,createEvent(1L, "Tech talk","24-Feb-2022"));
        eventData.put(2L,createEvent(2L, "Hackathon","25-Feb-2022"));
        eventData.put(3L,createEvent(3L, "Knowledge sharing","26-Feb-2022"));
        eventData.put(4L,createEvent(4L, "Team building","27-Feb-2022"));
        eventData.put(5L,createEvent(5L, "Company trip","28-Feb-2022"));
    }

    private EventEntity createEvent(long id, String title, String dateAsString) throws ParseException {
        return new EventEntity(id, title, convertStringToDate(dateAsString));
    }

    private Date convertStringToDate(String dateAsString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateInString = dateAsString;
        return formatter.parse(dateInString);
    }
}
