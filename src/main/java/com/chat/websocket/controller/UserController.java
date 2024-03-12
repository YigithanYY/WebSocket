package com.chat.websocket.controller;

import com.chat.websocket.model.User;
import com.chat.websocket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public void addUser(@Payload User user) {
        userService.saveUser(user);
    }


    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public void disconnectUser(@Payload User user) {
        userService.disconnect(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>>findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
