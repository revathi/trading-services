package net.springboot.ipotrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springboot.ipotrading.model.User;
import net.springboot.ipotrading.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByUserName(String userName) {

		return userRepository.findByUserName(userName);
	}
	@Override
	public  User findByEmail(String email){
		return userRepository.findByEmail(email);
	}
}
