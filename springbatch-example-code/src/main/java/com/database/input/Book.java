package com.database.input;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
public class Book {
	private String title;
	private String author;
	private String year;
	private String price;
	private String _category;


	// Getter Methods 

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getYear() {
		return year;
	}

	public String getPrice() {
		return price;
	}

	public String get_category() {
		return _category;
	}

	// Setter Methods 

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void set_category(String _category) {
		this._category = _category;
	}
}