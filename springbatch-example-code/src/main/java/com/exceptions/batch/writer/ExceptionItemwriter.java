package com.exceptions.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.database.input.Book;
import com.exceptions.batch.model.ExceptionDataStore;

public class ExceptionItemwriter implements ItemWriter<Book>{

	@Autowired
	ExceptionDataStore exceptionDataStore;
	
	@Override
	public void write(List<? extends Book> items) throws Exception {

		items.forEach(t -> {
			if (!exceptionDataStore.containsKey(t.getTitle())) {
				System.out.println("Adding new book " + t.getTitle());
				exceptionDataStore.put(t.getTitle(),t);
			}
		});
	}

}
