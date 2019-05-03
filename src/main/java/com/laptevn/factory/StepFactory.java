package com.laptevn.factory;

import com.laptevn.Bank;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepFactory {
    private final StepBuilderFactory stepBuilderFactory;
    private final FlatFileItemReader<Bank> reader;
    private final JdbcBatchItemWriter<Bank> writer;
    private final int batchSize;

    public StepFactory(
            StepBuilderFactory stepBuilderFactory,
            FlatFileItemReader<Bank> reader,
            JdbcBatchItemWriter<Bank> writer,
            @Value("${batch-size}") int batchSize) {
        this.stepBuilderFactory = stepBuilderFactory;
        this.reader = reader;
        this.writer = writer;
        this.batchSize = batchSize;
    }

    @Bean
    public Step createStep() {
        return stepBuilderFactory.get("step")
                .<Bank, Bank> chunk(batchSize)
                .reader(reader)
                .writer(writer)
                .build();
    }
}