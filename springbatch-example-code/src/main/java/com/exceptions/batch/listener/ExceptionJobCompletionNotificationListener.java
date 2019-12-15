package com.exceptions.batch.listener;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.database.input.Book;
import com.exceptions.batch.model.ExceptionDataStore;
import com.exceptions.batch.model.FxMarketPricesStore;
import com.exceptions.batch.model.StockPriceDetails;

/**
 * The Class JobCompletionNotificationListener
 *
 */
public class ExceptionJobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(ExceptionJobCompletionNotificationListener.class);

	private static final String HEADER = "Title,Category,Author,Price,Year";

	private static final String LINE_DILM = ",";

	@Autowired
	private ExceptionDataStore exceptionDataStore;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.trace("Loading the results into file");
			Path path = Paths.get("bookInfo.csv");
			try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
				fileWriter.write(HEADER);
				fileWriter.newLine();
				for (Book pd : exceptionDataStore.values()) {
					fileWriter.write(new StringBuilder().append(pd.getTitle())
							.append(LINE_DILM).append(pd.get_category())
							.append(LINE_DILM).append(pd.getAuthor())
							.append(LINE_DILM).append(pd.getPrice())
							.append(LINE_DILM).append(pd.getYear()).toString());
					fileWriter.newLine();
				}
			} catch (Exception e) {
				log.error("Fetal error: error occurred while writing {} file", path.getFileName());
			}
		}
	}
}
