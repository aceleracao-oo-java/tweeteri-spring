package com.tweetero.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.tweetero.api.DTO.TweetsDTO;
import com.tweetero.api.models.Tweet;
import com.tweetero.api.models.User;
import com.tweetero.api.repositories.AuthRepository;
import com.tweetero.api.repositories.TweetsRepository;

@Service
public class TweetsService {
    @Autowired
    private TweetsRepository tweetsRepository;

    @Autowired
    private AuthRepository authRepository;

    public void saveTweet(TweetsDTO req){
        User userData = authRepository.findByUsername(req.username());
        String avatar = userData.getAvatar();
        Tweet tweet = new Tweet(req);
        tweet.setAvatar(avatar);
        tweetsRepository.save(tweet);
    }

    public List<Tweet> getTweetsByUsername(String data){
        return tweetsRepository.findByUsername(data);
    }

    public List<Tweet> getTweetsByPage(int page){
        Page<Tweet> tweetsPage = tweetsRepository.findAll(PageRequest.of(page, 5).withSort(Direction.DESC, "id"));
        return tweetsPage.getContent();
    }
}
