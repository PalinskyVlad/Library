package by.itsupportme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.itsupportme.entity.User;
import by.itsupportme.repository.UserRepository;
import by.itsupportme.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        
        if (user == null) {
        	String msg = "User with login = '" + login + "' was not found!";
            throw new UsernameNotFoundException(msg);
        }
        
        return user;
    }

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}
		
}
