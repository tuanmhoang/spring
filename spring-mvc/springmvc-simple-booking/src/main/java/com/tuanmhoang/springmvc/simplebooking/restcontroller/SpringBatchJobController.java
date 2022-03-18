package com.tuanmhoang.springmvc.simplebooking.restcontroller;

import com.tuanmhoang.springmvc.simplebooking.model.TicketDto;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("ticket")
public class SpringBatchJobController {

    private final JobLauncher jobLauncher;

    private final Job importTicketJob;

    @GetMapping("importjob")
    public String invokeBatchJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
            .addLong("time", System.currentTimeMillis())
            .toJobParameters();
        jobLauncher.run(importTicketJob, jobParameters);
        return "Batch job has been invoked";
    }

}
