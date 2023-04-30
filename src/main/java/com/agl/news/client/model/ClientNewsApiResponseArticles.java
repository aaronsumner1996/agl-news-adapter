package com.agl.news.client.model;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class ClientNewsApiResponseArticles {

    private String title;

    private String author;

    private ClientNewsApiResponseArticlesSource source;

    private String publishedAt;

    private URL url;


}
