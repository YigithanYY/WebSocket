package com.chat.websocket.repository;

import com.chat.websocket.model.Status;
import com.chat.websocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository  extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}