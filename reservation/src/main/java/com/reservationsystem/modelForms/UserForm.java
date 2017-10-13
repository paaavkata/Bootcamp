package com.reservationsystem.modelForms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
	
	@NotNull
    @Size(min=2, max=30)
	private String email;
	
	@NotNull
    @Size(min=6, max=30)
    private String password;
	private long id;
	
	public UserForm() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
