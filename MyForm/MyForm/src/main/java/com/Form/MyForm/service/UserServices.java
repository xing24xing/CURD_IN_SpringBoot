package com.Form.MyForm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Form.MyForm.entity.UserDetails;
import com.Form.MyForm.repository.UserRepository;

@Service
public class UserServices {
@Autowired
private UserRepository ur;
public UserDetails login (String username ,String password) {
	UserDetails user = ur.findByUsernameAndPassword(username,password);
	return user;
}

}
