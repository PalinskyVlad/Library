package by.itsupportme.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itsupportme.entity.Book;
import by.itsupportme.entity.Reader;
import by.itsupportme.entity.TemporaryPossession;
import by.itsupportme.repository.BookRepository;
import by.itsupportme.repository.TemporaryPossessionRepository;
import by.itsupportme.repository.UserRepository;
import by.itsupportme.service.TemporaryPossessionService;

@Service
public class TemporaryPossessionServiceImpl implements TemporaryPossessionService {
	
	@Autowired
	private TemporaryPossessionRepository temporaryPossessionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private BookRepository bookRepository;

	@Override
	public Set<TemporaryPossession> getAllTemporaryPossessionsOfReader(String readerLogin) {
		Reader reader = (Reader) userRepository.findByLogin(readerLogin);
		return reader.getTemporaryPossessions();
	}

	@Override
	public List<TemporaryPossession> getAllTemporaryPossessions() {
		return temporaryPossessionRepository.findAll();
	}

	@Override
	public boolean createTemporaryPossession(String login, long bookId) {
		Reader reader = (Reader) userRepository.findByLogin(login);
		if (reader == null) {
			return false;
		}
		Book book = bookRepository.findOne(bookId);
		if (book == null && !book.isInLibrary()) {
			return false;
		}
		TemporaryPossession temporaryPossession = new TemporaryPossession();
		
		book.setInLibrary(false);
		temporaryPossession.setBook(book);
		temporaryPossession.setReader(reader);
		temporaryPossession.setStartDate(new Date());
		
		temporaryPossessionRepository.saveAndFlush(temporaryPossession);
		
		return true;
	}
	
	@Override
	public boolean editTemporaryPossession(long bookId) {
		TemporaryPossession temporaryPossession = temporaryPossessionRepository.findTemporaryPossessionByBookId(bookId);
		if (temporaryPossession == null) {
			return false;
		}
		Book book = bookRepository.findOne(bookId);
		book.setInLibrary(true);
		temporaryPossession.setEndDate(new Date());
		
		bookRepository.saveAndFlush(book);
		temporaryPossessionRepository.saveAndFlush(temporaryPossession);
		
		return true;
	}
	
}
