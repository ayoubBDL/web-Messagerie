package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Beans.User;
public interface UserRepository extends JpaRepository<User, String>{

}
