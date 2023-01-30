package com.example.provider.controller;

import com.example.provider.pojo.provider;
import com.example.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class providerController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    private final ProviderService providerService;

    @Autowired
    public providerController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping(value = "/userinfo")
    public ResponseEntity<String> create(@RequestBody provider newUser) {
        provider user = providerService.save(newUser);
        if (user == null) {
            throw new IllegalArgumentException("user is null");
        } else {
            return new ResponseEntity<>("User Created", HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/userinfo")
    public ResponseEntity<List<provider>> getAll() {
        List<provider> users = providerService.getAll();
        if (users == null) {
            throw new IllegalArgumentException("user is null");
        } else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }
}
