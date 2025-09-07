package io.github.justincodinguk.icdmediator.service;

import io.github.justincodinguk.icdmediator.model.IcdEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class IcdApiService {

    private final WebClient webClient;
    private final WebClient.Builder builder;

    public IcdApiService(@Value("${icd.api.base-url}") String baseUrl, WebClient.Builder builder) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.builder = builder;
    }

    @Cacheable(value = "icdCache", key = "#search")
    public Mono<List<IcdEntity>> getEntities(String search) {

        final IcdApiRequest request = new IcdApiRequest(search);

        final Mono<IcdApiResponse> response = webClient.get()
                .uri(builder -> builder.path("/icd/entity/search").queryParam("q", search).build())
                .header("API-Version", "v2")
                .header("Accept-Language", "en")
                .attribute(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(IcdApiResponse.class);

        return response.map(IcdApiResponse::getDestinationEntities);
    }


}
