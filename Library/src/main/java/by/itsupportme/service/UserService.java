package by.itsupportme.service;

import by.itsupportme.entity.User;

public interface UserService {

	User findUserByLogin(String login);
	
}
