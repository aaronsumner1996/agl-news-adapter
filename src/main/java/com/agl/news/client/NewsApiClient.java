package com.agl.news.client;

import com.agl.news.client.model.ClientNewsApiResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Client(value = "${news-adapter.api.url}")
public interface NewsApiClient {


    @Get(value = "/v2/everything", produces = APPLICATION_JSON)
    HttpResponse<ClientNewsApiResponse> retrieveNewsForGame(@QueryValue(value = "q") String gameName,
                                                            @QueryValue(value = "from") String dateFrom,
                                                            @QueryValue(value = "to") String dateTo,
                                                            @QueryValue(value = "domains") String domains,
                                                            @QueryValue(value = "language") String language,
                                                            @QueryValue(value = "sortby") String sortBy,
                                                            @Header(value = "X-Api-Key") String apiKey,
                                                            @Header(value = "User-Agent") String userAgent
                                                            );
}
