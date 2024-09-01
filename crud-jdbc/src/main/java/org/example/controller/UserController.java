package org.example.controller;

import org.example.model.user.User;
import org.example.config.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @GetMapping()
    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> response = userDAO.getAll();
            if (response.isEmpty()) return ResponseEntity.noContent().build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Integer id) {
        try {
            User response = userDAO.getById(id);
           if (response != null) return ResponseEntity.ok().body(response);
           return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> insert(@RequestBody User user) {
        try {
            int result = userDAO.insert(user);
            if (result > 0) return  ResponseEntity.created(URI.create("/users" + result)).build();
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            boolean result = userDAO.delete(id);
            return result ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}