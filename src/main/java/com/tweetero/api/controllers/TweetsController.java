package com.tweetero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.DTO.TweetsDTO;
import com.tweetero.api.models.Tweet;
import com.tweetero.api.services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetsService service;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid TweetsDTO req) {
        service.saveTweet(req);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tweet>> getLastTweets(@RequestParam(defaultValue = "0", required = false) int page) {

        List<Tweet> tweets = service.getTweetsByPage(page);
        return ResponseEntity.ok().body(tweets);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweet>> getTweetsByUsername(@PathVariable() String username) {
        List<Tweet> userTweets = service.getTweetsByUsername(username);

        return ResponseEntity.ok().body(userTweets);
    }
}
