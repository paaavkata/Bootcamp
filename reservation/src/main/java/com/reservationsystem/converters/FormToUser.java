package com.reservationsystem.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.reservationsystem.modelForms.UserForm;
import com.reservationsystem.models.User;

@Component	
public class FormToUser implements Converter<UserForm, User>{

	@Override
	public User convert(UserForm userForm) {
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		return user;
	}

}
