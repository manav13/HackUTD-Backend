package in.mnp200002.chatsApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mnp200002.chatsApi.model.Login;
import in.mnp200002.chatsApi.repository.LoginRepository;

@Service
public class LoginService implements LoginServiceInterface {

	public final LoginRepository loginRepository;
	
	@Autowired
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public boolean authorize(Login login) {
		Login currentUserDetails = loginRepository.getById(login.getUser_id());
		
		if(currentUserDetails.getPassword().equals(login.getPassword())) {
			return true;
		}
		else return false;
	}
}
