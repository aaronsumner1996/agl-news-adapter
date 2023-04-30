package com.agl.news.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class ClientNewsApiResponseArticlesSource {

    @JsonProperty(value = "Id")
    private String id;

    @JsonProperty(value = "Name")
    private String name;

}
