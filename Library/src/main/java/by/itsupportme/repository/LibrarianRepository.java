package by.itsupportme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itsupportme.entity.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

}
