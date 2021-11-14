package in.mnp200002.chatsApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mnp200002.chatsApi.model.User;
import in.mnp200002.chatsApi.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	public final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public String getUserName(Integer id) {
		User user = userRepository.findById(id).get();
		return user.getName();
	}
}
