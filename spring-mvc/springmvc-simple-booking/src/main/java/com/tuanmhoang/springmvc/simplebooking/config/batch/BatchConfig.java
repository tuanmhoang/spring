package com.tuanmhoang.springmvc.simplebooking.config.batch;

import com.tuanmhoang.springmvc.simplebooking.model.TicketDto;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
@Slf4j
public class BatchConfig extends DefaultBatchConfigurer {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final DataSource dataSource;

    @Override
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(null);
    }

    @Bean
    public ItemReader<TicketDto> reader() {
        Jaxb2Marshaller ticketMarshaller = new Jaxb2Marshaller();
        ticketMarshaller.setClassesToBeBound(TicketDto.class);

        return new StaxEventItemReaderBuilder<TicketDto>()
            .name("ticketReader")
            .resource(new ClassPathResource("batch/ticketbatch.xml"))
            .addFragmentRootElements("ticket")
            .unmarshaller(ticketMarshaller)
            .build();
    }

    @Bean
    public JdbcBatchItemWriter<TicketDto> writer() {
        return new JdbcBatchItemWriterBuilder<TicketDto>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TicketDto>())
            .sql("INSERT INTO tbl_ticket (event_id, user_id, category, place) VALUES (:eventId, :userId, :category, :place)")
            .dataSource(dataSource)
            .build();
    }

    @Bean
    public Job importTicketJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importTicketJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<TicketDto> writer) {
        return stepBuilderFactory.get("step1")
            .<TicketDto, TicketDto>chunk(10)
            .reader(reader())
            .processor(new TicketItemProcessor())
            .writer(writer)
            .build();
    }

}
