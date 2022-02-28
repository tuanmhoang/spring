package com.tuanmhoang.spring.xml.data;

import com.google.gson.Gson;
import com.tuanmhoang.spring.xml.entities.TicketEntity;
import com.tuanmhoang.spring.xml.model.enums.Category;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

//@Getter
//@Setter
//@Slf4j
public class TicketDataService {

    private Map<Long, TicketEntity> ticketData = new HashMap<>();
//    private static Logger log = LoggerFactory.getLogger(TicketDataService.class);

    private static final Logger log = LogManager.getLogger(TicketDataService.class);

    public void init() throws FileNotFoundException {


        File fileData = ResourceUtils.getFile("classpath:data/ticket.json");

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(fileData)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            Gson gson = new Gson();

            final String json = obj.toString();
            TicketEntity[] ticketEntities = gson.fromJson(json, TicketEntity[].class);
            for (TicketEntity ticketEntity : ticketEntities) {
                ticketData.put(ticketEntity.getId(), createTicketData(
                        ticketEntity.getId(),
                        ticketEntity.getEventId(),
                        ticketEntity.getUserId(),
                        ticketEntity.getCategory(),
                        ticketEntity.getPlace()
                    )
                );
            }

        } catch (FileNotFoundException e) {
            log.error(">>> Exception: {} ", e);
        } catch (IOException e) {
            log.error(">>> Exception: {} ", e);
        } catch (ParseException e) {
            log.error(">>> Exception: {} ", e);
        }
    }

    private TicketEntity createTicketData(long id, long eventId, long userId, Category category, int place) {
        return new TicketEntity(id, eventId, userId, category, place);
    }

    public Map<Long, TicketEntity> getTicketData() {
        return ticketData;
    }

    public void setTicketData(Map<Long, TicketEntity> ticketData) {
        this.ticketData = ticketData;
    }

}
