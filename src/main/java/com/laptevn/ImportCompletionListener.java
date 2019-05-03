package com.laptevn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ImportCompletionListener extends JobExecutionListenerSupport {
    private static final Logger logger = LoggerFactory.getLogger(ImportCompletionListener.class);

    private final JdbcTemplate jdbcTemplate;
    private final long queryId;

    public ImportCompletionListener(JdbcTemplate jdbcTemplate, @Value("${query-id}") long queryId) {
        this.jdbcTemplate = jdbcTemplate;
        this.queryId = queryId;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("Import completed");

            try {
                String name = jdbcTemplate.queryForObject(Scripts.QUERY_BY_ID, new Object[] { queryId }, String.class);
                logger.info("Name of bank for {} is {}", queryId, name);
            } catch (EmptyResultDataAccessException ignore) {
                logger.info("No bank found with {} id", queryId);
            }
        } else {
            logger.error("Import wasn't performed");
        }
    }
}