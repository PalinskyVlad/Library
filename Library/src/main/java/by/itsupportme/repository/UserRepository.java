package by.itsupportme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itsupportme.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

}
