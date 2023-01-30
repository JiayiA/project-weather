package com.example.search.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.search.model.provider;
import com.example.search.model.Student;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/search")
    public ResponseEntity<?> getDetails() {
        //TODO
        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }

    @GetMapping("/search/userinfo")
    public ResponseEntity<?> getProvider() {
        String baseProviderUrl = "https://provider-service";
        List<provider> providers = restTemplate.getForObject(baseProviderUrl+"/userinfo",  List.class);
        return new ResponseEntity<>(providers, HttpStatus.OK);
    }

    @GetMapping("/search/students")
    public ResponseEntity<List<Student>> getStudent() {
        String baseStudentUrl = "https://student-service";
        List<Student> students = restTemplate.getForObject(baseStudentUrl+"/students", List.class);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
