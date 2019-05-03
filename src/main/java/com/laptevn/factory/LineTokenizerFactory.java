package com.laptevn.factory;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LineTokenizerFactory {
    private final static String DELIMITER = ";";
    private final static String[] COLUMN_NAMES = new String[]{ "name", "id" };

    @Bean
    public DelimitedLineTokenizer createLineTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(DELIMITER);
        tokenizer.setNames(COLUMN_NAMES);
        return tokenizer;
    }
}