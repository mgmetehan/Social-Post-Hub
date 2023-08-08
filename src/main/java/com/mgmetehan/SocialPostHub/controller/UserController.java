package com.mgmetehan.SocialPostHub.controller;

import com.mgmetehan.SocialPostHub.service.UsersService;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersRequest;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersUpdateRequest;
import com.mgmetehan.SocialPostHub.shared.model.response.UsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(UserEndpoints.USERS) !!! TODO: Add UserEndpoints
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<UsersResponse> create(@RequestBody UsersRequest newUsers) {
        kafkaTemplate.send("users", newUsers.getFirstName());
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.create(newUsers));
    }

    @GetMapping("/{id}")
    //TODO: GetParamsDto -> Specofocaton
    public ResponseEntity<UsersResponse> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsersResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        usersService.delete(id);
        //TODO: return user deleted message
    }

    @PutMapping
    public ResponseEntity<UsersResponse> update(@RequestBody UsersUpdateRequest updateUsers) {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.update(updateUsers));
    }

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
