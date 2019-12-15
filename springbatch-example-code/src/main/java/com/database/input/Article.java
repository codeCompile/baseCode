package com.database.input;

public class Article {

	private int Id;
	private String Description;
	private String ClobBody;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getClobBody() {
		return ClobBody;
	}
	public void setClobBody(String clobBody) {
		ClobBody = clobBody;
	}
}
