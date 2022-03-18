package com.tuanmhoang.springmvc.simplebooking.restcontroller;

import com.tuanmhoang.springmvc.simplebooking.entity.Event;
import com.tuanmhoang.springmvc.simplebooking.helper.PdfHelper;
import com.tuanmhoang.springmvc.simplebooking.service.EventService;
import java.io.ByteArrayInputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("event")
public class EventRestController {

    private final EventService eventService;

    @GetMapping("all")
    public List<Event> getEvents(){
        return eventService.findAll();
    }

    @GetMapping("pdf")
    public ResponseEntity<InputStreamResource> getPDF() throws Exception {

        var events = eventService.findAll();

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        ByteArrayInputStream bis = PdfHelper.generateReport(events);

        return ResponseEntity
            .ok()
            .headers(headers)
            .contentType(MediaType.APPLICATION_PDF)
            .body(new InputStreamResource(bis));
    }
}
