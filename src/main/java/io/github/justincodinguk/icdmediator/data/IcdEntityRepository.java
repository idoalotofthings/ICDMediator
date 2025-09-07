package io.github.justincodinguk.icdmediator.data;

import io.github.justincodinguk.icdmediator.model.IcdEntity;
import io.github.justincodinguk.icdmediator.service.IcdApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class IcdEntityRepository {

    private final IcdApiService apiService;

    @Autowired
    public IcdEntityRepository(IcdApiService apiService) {
        this.apiService = apiService;
    }

    public Mono<List<IcdEntity>> searchFor(String search) {
        return apiService.getEntities(search);
    }

}
