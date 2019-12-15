package com.exceptions.batch.reader;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.database.input.Article;
import com.database.input.ExceptionRowMapper;
import com.exceptions.batch.YmlConfig;

public class DatabaseItemReader extends JdbcCursorItemReader<Article> {

	public DatabaseItemReader()
	{
		//dataSource = mySqlDataSource();
	}

	//@PostConstruct
	public DatabaseItemReader init(DataSource dataSource)
	{
		this.setDataSource(dataSource);

		this.setRowMapper(new ExceptionRowMapper());

		this.setSql("select * from clobArticle");

		return this;
	}
}
