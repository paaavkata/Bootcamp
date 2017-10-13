package com.reservationsystem.serviceImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.reservationsystem.converters.FormToUser;
import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.models.User;
import com.reservationsystem.repositories.UserRepository;
import com.reservationsystem.services.UserService;
import com.reservationsystem.util.Notification;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private FormToUser formToUser;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, FormToUser formToUser) {
        this.userRepository = userRepository;
        this.formToUser = formToUser;
    }
	
	@Override
	public Notification getNotifications(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User validLogin(UserForm userForm) {
		User user = userRepository.findByEmail(userForm.getEmail());
		try{
			if(BCrypt.checkpw(userForm.getPassword(), user.getPassword())){
				System.out.println("Pass and username match with DB. User " + userForm.getEmail() + " logged in.");
				return user;
			}
		}
		catch(IllegalArgumentException e){
			System.out.println("Invalid salt version for user " + user.getEmail());
		}
		return null;
	}
	
	public User registerUser(UserForm userForm){
		String pw_hash = BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt());
		userForm.setPassword(pw_hash);
		User user = userRepository.save(formToUser.convert(userForm));
		return user;
	}
	
	@Override
	public User getProfile(UserForm userForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, String> getLevels() {
		// TODO Auto-generated method stub
		return null;
	}

}
