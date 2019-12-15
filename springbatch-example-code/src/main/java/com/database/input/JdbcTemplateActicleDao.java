package com.database.input;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class JdbcTemplateActicleDao implements Dao<Article>{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	public JdbcTemplateActicleDao()
	{
		jdbcTemplate = new JdbcTemplate();
		DriverManagerDataSource tmp = new DriverManagerDataSource();
		tmp.setDriverClassName("com.mysql.cj.jdbc.Driver");
		tmp.setUrl("jdbc:mysql://localhost:3306/world"); tmp.setUsername("arv");
		tmp.setPassword("arv@1234"); 
		jdbcTemplate.setDataSource(tmp);
	}
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	@Override
	public long save(Article article) {
		String sql = "insert into clobArticle (ID, SubjectInfo, Body) values (?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				connection -> {
					PreparedStatement ps = connection.prepareStatement(sql, new String[]{"ID"});
					ps.setInt(1, article.getId());
					ps.setString(2, article.getDescription());
					ps.setString(3, article.getClobBody());
					return ps;
				}, keyHolder);
		Number key = keyHolder.getKey();
		return key.longValue();
	}

	@Override
	public Article load(long id) {
		List<Article> articles = jdbcTemplate.query("select * from clobArticle where ID =?",
				new Object[]{id}, (resultSet, i) -> {
					return toArticle(resultSet);
				});

		if (articles.size() == 1) {
			return articles.get(0);
		}
		return null;
	}

	@Override
	public int delete(long id) {
		return jdbcTemplate.update("delete from clobArticle where ID = ?", id);
	}

	@Override
	public int update(Article article) {
		String updateSql = "UPDATE clobArticle SET SubjectInfo = ?, Body = ?, "
				+ " WHERE ID = ?";
		return jdbcTemplate.update(updateSql, article.getDescription(), article.getClobBody(),
				article.getId());
	}
	
	public void updateDescription(Integer id, String description) {
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("id", id);
		in.addValue("description",  new SqlLobValue(description, 
				new DefaultLobHandler()), Types.CLOB);

		String SQL = "update Student set description = :description where id = :id";
	//	NamedParameterJdbcTemplate jdbcTemplateObject = new 
		//		NamedParameterJdbcTemplate(dataSource);

//		jdbcTemplateObject.update(SQL, in);
		System.out.println("Updated Record with ID = " + id );
	}

	@Override
	public List<Article> loadAll() {
		return jdbcTemplate.query("select * from clobArticle", (resultSet, i) -> {
			return toArticle(resultSet);
		});
	}
	private Article toArticle(ResultSet resultSet) throws SQLException {
		Article article = new Article();
		article.setId(resultSet.getInt("ID"));
		article.setDescription(resultSet.getString("SubjectInfo"));
		article.setClobBody(resultSet.getString("Body"));
		return article;
	}
}
