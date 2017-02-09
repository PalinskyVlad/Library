package by.itsupportme.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itsupportme.entity.Book;
import by.itsupportme.entity.Reader;
import by.itsupportme.entity.TemporaryPossession;
import by.itsupportme.repository.BookRepository;
import by.itsupportme.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooksInLibrary() {
		return bookRepository.findAllBooksInLibrary();
	}

	@Override
	public List<Book> getBooksIssuedOnHands() {
		return bookRepository.findAllBooksIsNotInLibrary();
	}

	@Override
	public List<Book> getAllBooksOfReader(Reader reader) {
		List<Book> books = new ArrayList<>();
		
		for(TemporaryPossession temporaryPossession : reader.getTemporaryPossessions()) {
			if (temporaryPossession.getEndDate() == null)
			 books.add(temporaryPossession.getBook());
		}
		return books;
	}

}
