package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Beans.Message;
public interface MessageRepository extends JpaRepository<Message, Long>{

}
