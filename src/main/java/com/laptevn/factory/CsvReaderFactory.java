package com.laptevn.factory;

import com.laptevn.Bank;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CsvReaderFactory {
    private final static String IMPORT_FILE = "import.csv";
    private final static int HEADER_LINES_COUNT = 1;

    private final DelimitedLineTokenizer tokenizer;

    public CsvReaderFactory(DelimitedLineTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Bean
    public FlatFileItemReader<Bank> createReader() {
        return new FlatFileItemReaderBuilder<Bank>()
                .name("bankReader")
                .resource(new ClassPathResource(IMPORT_FILE))
                .lineTokenizer(tokenizer)
                .linesToSkip(HEADER_LINES_COUNT)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Bank>() {{
                    setTargetType(Bank.class);
                }})
                .build();
    }
}