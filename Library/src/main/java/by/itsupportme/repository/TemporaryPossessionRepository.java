package by.itsupportme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import by.itsupportme.entity.TemporaryPossession;


@Repository
public interface TemporaryPossessionRepository extends JpaRepository<TemporaryPossession, Long> {
	@Query("select tp from TemporaryPossession tp where tp.book.id = :bookId and tp.endDate = null")
	TemporaryPossession findTemporaryPossessionByBookId(@Param("bookId") long bookId);
}
