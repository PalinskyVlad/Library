package by.itsupportme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itsupportme.entity.Reader;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
