package com.agl.news.controller;

import com.agl.news.client.model.ClientNewsApiResponse;
import com.agl.news.controller.model.NewsRequest;
import com.agl.news.service.NewsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class NewsController1 {

    private final NewsService newsService;

    @Inject
    public NewsController1(NewsService newsService) {
        this.newsService = newsService;
    }

    @Put(value = "/api/games/news",consumes = MediaType.APPLICATION_JSON)
    public ClientNewsApiResponse retrieveNewsForUser(@Body NewsRequest newsRequest) {
        String urlEncoded = URLEncoder.encode(newsRequest.getGameName(), StandardCharsets.UTF_8);
        return newsService.retrieveNewsForGame(urlEncoded);
    }

}
