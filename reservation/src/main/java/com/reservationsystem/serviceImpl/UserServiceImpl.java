package com.reservationsystem.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.reservationsystem.converters.FormToUser;
import com.reservationsystem.model.Notification;
import com.reservationsystem.model.User;
import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.repositories.UserRepository;
import com.reservationsystem.services.UserService;

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
	public List<Notification> getNotifications(User user) {
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
	public HashMap<Integer, String> getLevels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listAll() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User getById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User saveOrUpdate(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);		
	}

}
