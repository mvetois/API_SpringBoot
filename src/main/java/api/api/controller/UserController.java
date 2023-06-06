package api.api.controller;

import api.api.persistance.entity.UserEntity;
import api.api.persistance.repository.UserRepository;
import api.api.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public ResponseEntity<String> findById(@RequestParam Integer id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return (ResponseEntity.notFound().build());
        }
        return (ResponseEntity.ok(user.get().toString()));
    }

    @GetMapping("/all")
    public String findAll() {
        return (userRepository.findAll().toString());
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UserRequest userRequest) {
        UserEntity user = new UserEntity(userRequest.getName(), userRequest.getEmail());
        userRepository.save(user);
        return (ResponseEntity.ok(user.toString()));
    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestParam Integer id, @RequestBody UserRequest userRequest) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return (ResponseEntity.notFound().build());
        }
        user.get().update(userRequest.getName(), userRequest.getEmail());
        userRepository.save(user.get());
        return (ResponseEntity.ok(user.get().toString()));
    }

    @DeleteMapping()
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            return (ResponseEntity.notFound().build());
        }
        userRepository.delete(user.get());
        return (ResponseEntity.ok(user.get().toString()));
    }
}
