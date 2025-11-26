package com.spring.controller;

import com.spring.model.Result;
import com.spring.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
public class ResultController
{
    @Autowired
    private ResultService resultService;

    @GetMapping("/show")
    public String Result()
    {
        return "Result will shown later";
    }

    @PostMapping("/generate/{studentid}")
    public ResponseEntity<Result> generate(@PathVariable("studentid") int studentid)
    {
        Result result = resultService.generateResult(studentid);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
