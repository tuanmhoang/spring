package com.tuanmhoang.springmvc.simplebooking.restcontroller;

import com.tuanmhoang.springmvc.simplebooking.helper.PdfHelper;
import com.tuanmhoang.springmvc.simplebooking.service.EventService;
import com.tuanmhoang.springmvc.simplebooking.service.UserService;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

@RestController
@RequiredArgsConstructor
public class EventRestController {

    private final EventService eventService;

    @GetMapping("/event/pdf")
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
