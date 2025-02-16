package com.esprit.ms.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="job")

public class JobRestAPI {

    private String hello="Hello, i'm the Job MS";

    @RequestMapping("/helloJ")
    public String sayHello(){
        return hello;
    }

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAll() {
        return new ResponseEntity<>(jobService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id){
        return new ResponseEntity<>(jobService.getJobById(id), HttpStatus.OK);

    }
}
