package com.exceptions.batch.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.database.input.Article;
import com.database.input.Book;

public class ExceptionDataStore {

	private Map<String, Book> exceptionEntity = new HashMap<String, Book>();

	public boolean containsKey(Object key) {
		return exceptionEntity.containsKey(key);
	}

	public Book put(String key, Book value) {
		return exceptionEntity.put(key, value);
	}

	public Collection<Book> values() {
		return exceptionEntity.values();
	}

	public Book get(Object key) {
		return exceptionEntity.get(key);
	}

}
