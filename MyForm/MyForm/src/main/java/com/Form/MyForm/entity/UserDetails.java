package com.Form.MyForm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; // Import added
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "register")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Removed the incorrect semicolon
    private int id;

    private String username;
    private String password;
    private String fullName;  // Add this field
    private String email;  

    // Default constructor
    public UserDetails() {
    }

    // Parameterized constructor
    public UserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() { // Changed to camelCase
        return password;
    }

    // Setter for password
    public void setPassword(String password) { // Changed to camelCase
        this.password = password;
    }

    // Overriding toString method
   
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 @Override
	    public String toString() {
	        return "UserDetails [id=" + id + ", username=" + username + ", password=" + password + "]";
	    }

}
