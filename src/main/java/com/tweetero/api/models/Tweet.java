package com.tweetero.api.models;

import com.tweetero.api.DTO.TweetsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Tweet {
    public Tweet(TweetsDTO data) {
        this.username = data.username();
        this.text = data.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 300, nullable = false)
    private String avatar;

    @Column(length = 300, nullable = false)
    private String text;
}