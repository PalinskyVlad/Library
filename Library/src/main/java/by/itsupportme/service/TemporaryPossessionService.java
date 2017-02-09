package by.itsupportme.service;

import java.util.List;
import java.util.Set;

import by.itsupportme.entity.TemporaryPossession;

public interface TemporaryPossessionService {
	
	Set<TemporaryPossession> getAllTemporaryPossessionsOfReader(String readerLogin);
	
	List<TemporaryPossession> getAllTemporaryPossessions();
	
	boolean createTemporaryPossession(String login, long bookId);
	
	boolean editTemporaryPossession(long bookId);
}
