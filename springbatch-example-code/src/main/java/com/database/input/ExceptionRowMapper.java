package com.database.input;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ExceptionRowMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Article article = new Article();
		article.setId(resultSet.getInt("ID"));
		article.setDescription(resultSet.getString("SubjectInfo"));
		article.setClobBody(resultSet.getString("Body"));
		return article;
	}
}
