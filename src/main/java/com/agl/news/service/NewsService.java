package com.agl.news.service;

import com.agl.news.client.NewsApiClient;
import com.agl.news.client.model.ClientNewsApiResponse;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Singleton
@Slf4j
public class NewsService {

    private final NewsApiClient newsApiClient;

    @Value("${news-adapter.api.key}")
    private String apiKey;

    @Value("${news-adapter.domains}")
    private List<String> domains;

    private static final String LANGUAGE = "en";
    private static final String SORT = "popularity";
    private static final String USER_AGENT = "Test";

    @Inject
    public NewsService(NewsApiClient newsApiClient) {
        this.newsApiClient = newsApiClient;
    }

    public ClientNewsApiResponse retrieveNewsForGame(String gameName) {
        String from = LocalDateTime.now().minusDays(28).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        String to = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        String domainList = String.join(",", domains);
        try {
            return newsApiClient
                    .retrieveNewsForGame(gameName, from, to, domainList, LANGUAGE, SORT, apiKey, USER_AGENT)
                    .body();
        } catch (Exception e) {
            log.error("Could not make request to News API");
            throw new HttpStatusException(HttpStatus.NOT_FOUND, "Could not make request to News API");
        }
    }
}
