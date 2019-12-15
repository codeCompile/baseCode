package com.database.input;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatabaseApplication {

	
	@Bean
	public Dao<Article> jdbcPersonDao() {
		return new JdbcTemplateActicleDao();
	}

	@Bean 
	public DataSource mySqlDataSource() {
		DriverManagerDataSource tmp = new DriverManagerDataSource();
		tmp.setDriverClassName("com.mysql.jdbc.Driver");
		tmp.setUrl("jdbc:mysql://localhost:3306/world");
		tmp.setUsername("arv");
		tmp.setPassword("arv@1234");
		return tmp;
	}
	/*
	 * @Bean public DataSource h2DataSource() { return new EmbeddedDatabaseBuilder()
	 * .setType(EmbeddedDatabaseType.H2) .addScript("createPersonTable.sql")
	 * .build(); }
	 */

}
