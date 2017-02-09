package by.itsupportme.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.itsupportme.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
