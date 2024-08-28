package org.example.controller;

import org.example.model.User.User;
import org.example.config.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @GetMapping()
    public ResponseEntity getAll() {
        try {
            ArrayList<User> response = userDAO.getAll();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) {
        try {
            User response = userDAO.getById(id);
           if (response != null) return ResponseEntity.ok().body(response);
           return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity insert(@RequestBody User user) {
        try {
            int result = userDAO.insert(user);
            return  ResponseEntity.created(URI.create("/users" + result)).build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            boolean result = userDAO.delete(id);
            return result ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}