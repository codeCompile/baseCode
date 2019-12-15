package com.exceptions.batch.processor;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.batch.item.ItemProcessor;

import com.database.input.Article;
import com.database.input.Book;

public class ExceptionProcessor implements ItemProcessor<Article, Book>  {

	@Override
	public Book process(Article item) throws Exception {

		String bookXml = item.getClobBody();
		StringReader strReader = new StringReader(bookXml);
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);  

		try
		{
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		Book book= (Book) jaxbUnmarshaller.unmarshal(strReader);  
		
		System.out.println("Processing new book : " + book.getTitle());
		return book;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new Book();
	}
}
