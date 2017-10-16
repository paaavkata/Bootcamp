package com.reservationsystem.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.models.User.User;
import com.reservationsystem.models.util.Notification;

@Service
public interface UserService {

	List<Notification> getNotifications(User user);

	User validLogin(UserForm userForm);

	HashMap<Integer, String> getLevels();

	User registerUser(UserForm userForm);
	
	List<User> listAll();

    User getById(long id);

    User saveOrUpdate(User user);

    void delete(long id);

}
