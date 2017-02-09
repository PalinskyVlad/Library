package by.itsupportme.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.itsupportme.entity.Book;
import by.itsupportme.entity.Reader;
import by.itsupportme.entity.User;

public interface BookService {

	List<Book> getAllBooksInLibrary();

	List<Book> getBooksIssuedOnHands();
	
	List<Book> getAllBooksOfReader(Reader reader);
}
