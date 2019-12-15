package com.exceptions.batch;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*
 * Annotation for externalized configuration. Add this to a class definition or a @Bean method in a @Configuration class if you want to bind and validatesome external Properties (e.g. from a .properties file). 
Note that contrary to @Value, SpEL expressions are not evaluated since propertyvalues are externalized.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YmlConfig {
  
    private String datasource_url;
    private String datasource_username;
    private String datasource_password;
    private String datasource_driver_class_name;
    
    private List<String> servers = new ArrayList<>();

	public String getDatasource_url() {
		return datasource_url;
	}

	public String getDatasource_username() {
		return datasource_username;
	}

	public String getDatasource_driver_class_name() {
		return datasource_driver_class_name;
	}

	public void setDatasource_url(String datasource_url) {
		this.datasource_url = datasource_url;
	}

	public void setDatasource_username(String datasource_username) {
		this.datasource_username = datasource_username;
	}

	public void setDatasource_driver_class_name(String datasource_driver_class_name) {
		this.datasource_driver_class_name = datasource_driver_class_name;
	}
 

	@Bean("mySqllocalDb")
	public DataSource mySqlDataSource() {
		DriverManagerDataSource tmp = new DriverManagerDataSource();
		//if(ymlConfig!=null)
		{ 
			System.out.print(getDatasource_driver_class_name() +
					getDatasource_url() + getDatasource_username());
		}
		tmp.setDriverClassName(getDatasource_driver_class_name());
		tmp.setUrl(getDatasource_url());
		tmp.setUsername(getDatasource_username());
		tmp.setPassword(getDatasource_password());
		return tmp;
	}
	
	
    // standard getters and setters

	public String getDatasource_password() {
		return datasource_password;
	}

	public void setDatasource_password(String datasource_password) {
		this.datasource_password = datasource_password;
	}
 
}