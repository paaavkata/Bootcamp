package com.reservationsystem.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.models.User.User;
import com.reservationsystem.models.util.Notification;

@Service
public interface UserService {

	Notification getNotifications(User user);

	User validLogin(UserForm userForm);

	User getProfile(UserForm userForm);

	HashMap<Integer, String> getLevels();

	User registerUser(UserForm userForm);

}
