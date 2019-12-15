package com.exceptions.batch;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.database.input.Article;
import com.database.input.Dao;
import com.database.input.JdbcTemplateActicleDao;

/**
 * The Class Application.
 * 
 */
@SpringBootApplication 
public class Application {
public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
