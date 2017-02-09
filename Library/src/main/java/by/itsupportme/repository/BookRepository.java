package by.itsupportme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import by.itsupportme.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("select b from Book b where b.inLibrary = true")
	List<Book> findAllBooksInLibrary();
	
	@Query("select b from Book b where b.inLibrary = false")
	List<Book> findAllBooksIsNotInLibrary();
	
}
