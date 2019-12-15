package com.exceptions.batch;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.database.input.Article;
import com.database.input.Book;
import com.exceptions.batch.listener.ExceptionJobCompletionNotificationListener;
import com.exceptions.batch.listener.JobCompletionNotificationListener;
import com.exceptions.batch.model.ExceptionDataStore;
import com.exceptions.batch.model.FxMarketEvent;
import com.exceptions.batch.model.FxMarketPricesStore;
import com.exceptions.batch.model.Trade;
import com.exceptions.batch.processor.ExceptionProcessor;
import com.exceptions.batch.processor.FxMarketEventProcessor;
import com.exceptions.batch.reader.DatabaseItemReader;
import com.exceptions.batch.reader.FxMarketEventReader;
import com.exceptions.batch.writer.ExceptionItemwriter;
import com.exceptions.batch.writer.StockPriceAggregator;

/**
 * The Class BatchConfiguration.
 * 
 */
@Configuration
@EnableBatchProcessing
//@Import(YmlConfig.class)
//@ComponentScan("com.fx.batch")
public class BatchConfiguration2 extends DefaultBatchConfigurer  {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Override
	public void setDataSource(DataSource dataSource) {
		// override to do not set datasource even if a datasource exist.
		// initialize will use a Map based JobRepository (instead of database)
	}

	/*
	@Value("${datasource.url}") 
	private String datasource_url;

	@Value("${datasource_username}") 
	private String datasource_username;

	@Value("${datasource_driver_class_name}") 
	private String datasource_driver_class_name;
	 */
	@Bean
	public ExceptionDataStore exceptionDataStore() {
		return new ExceptionDataStore();
	}


	@Autowired
	@Qualifier("mySqllocalDb") 
	private DataSource dataSource;

	@Autowired
	private ApplicationContext applicationContext;

	// Exception (Reader)
	@Bean(destroyMethod = "")
	public DatabaseItemReader databaseItemReader() {
		DatabaseItemReader tmp = new DatabaseItemReader();
		//AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
		//factory.autowireBean( tmp );
		//factory.initializeBean( tmp, "bean" );

		return tmp.init(dataSource);
	}

	// ExceptionProcessor (Processor)
	@Bean
	public ExceptionProcessor exceptionProcessor() {
		return new ExceptionProcessor();
	}

	// Exceptionwriter (Writer)
	@Bean
	public ExceptionItemwriter exceptionItemwriter() {
		return new ExceptionItemwriter();
	}

	// JobCompletionNotificationListener (File loader)
	@Bean
	public JobExecutionListener listener() {
		return new ExceptionJobCompletionNotificationListener();
	}

	// Configure job step
	@Bean
	public Job exceptionProcessorETLJob() {
		return jobBuilderFactory.get("Exception Processor ETL Job").incrementer(new RunIdIncrementer())
				.listener(listener()).flow(etlStep()).end().build();
	}

	@Bean
	public Step etlStep() {
		return stepBuilderFactory.get("Extract -> Transform -> Aggregate -> Load").<Article, Book>chunk(10000)
				.reader(databaseItemReader()).processor(exceptionProcessor()).writer(exceptionItemwriter()).build();
	}

	/*
 	@Bean
 	public Job job() {
 		return jobs.get("myJob").start(step1()).next(step2()).build();
 	}
 	@Bean
    protected Step step1() {
       ...
    }
 	@Bean
    protected Step step2() {
     ...
	 */
}
