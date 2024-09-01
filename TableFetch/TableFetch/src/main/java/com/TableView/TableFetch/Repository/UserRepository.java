package com.TableView.TableFetch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TableView.TableFetch.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
     User findByEmail(String email);
}
