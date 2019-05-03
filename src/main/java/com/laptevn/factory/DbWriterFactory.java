package com.laptevn.factory;

import com.laptevn.Bank;
import com.laptevn.Scripts;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbWriterFactory {
    @Bean
    public JdbcBatchItemWriter<Bank> createWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Bank>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(Scripts.INSERT)
                .dataSource(dataSource)
                .build();
    }
}