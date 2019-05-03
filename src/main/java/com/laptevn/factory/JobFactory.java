package com.laptevn.factory;

import com.laptevn.ImportCompletionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobFactory {
    private final JobBuilderFactory jobBuilderFactory;
    private final Step step;
    private final ImportCompletionListener listener;

    public JobFactory(JobBuilderFactory jobBuilderFactory, Step step, ImportCompletionListener listener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.step = step;
        this.listener = listener;
    }

    @Bean
    public Job createJob() {
        return jobBuilderFactory.get("importBankJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }
}