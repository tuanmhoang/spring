package com.tuanmhoang.spring.xml.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tuanmhoang.spring.xml.entities.EventEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.springframework.util.ResourceUtils;

//@Getter
//@Setter
//@Slf4j
public class EventDataService {
    private Map<Long, EventEntity> data = new HashMap<>();

//    private static Logger log = LoggerFactory.getLogger(EventDataService.class);

    private static final Logger log = LogManager.getLogger(EventDataService.class);

    public void init() throws ParseException, FileNotFoundException {

        File fileData = ResourceUtils.getFile("classpath:data/event.json");

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileData)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

            final String json = obj.toString();
            EventEntity[] eventEntities = gson.fromJson(json, EventEntity[].class);
            for (EventEntity eventEntity : eventEntities) {
                data.put(eventEntity.getId(), createEvent(
                        eventEntity.getId(),
                        eventEntity.getTitle(),
                        eventEntity.getDate()
                    )
                );
            }

        } catch (FileNotFoundException e) {
            log.error(">>> Exception: {} ", e);
        } catch (IOException e) {
            log.error(">>> Exception: {} ", e);
        } catch (org.json.simple.parser.ParseException e) {
            log.error(">>> Exception: {} ", e);
        }
    }

    private EventEntity createEvent(long id, String title, Date date) throws ParseException {
        return new EventEntity(id, title, date);
    }

    public Map<Long, EventEntity> getData() {
        return data;
    }

    public void setData(Map<Long, EventEntity> data) {
        this.data = data;
    }

}
