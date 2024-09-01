package com.Form.MyForm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Form.MyForm.entity.UserDetails;

@Repository
public interface UserRepository  extends JpaRepository <UserDetails,Integer>{
UserDetails findByUsernameAndPassword(String username,String password);
}
