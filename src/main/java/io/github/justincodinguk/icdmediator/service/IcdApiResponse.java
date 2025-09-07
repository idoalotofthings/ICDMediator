package io.github.justincodinguk.icdmediator.service;

import io.github.justincodinguk.icdmediator.model.IcdEntity;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class IcdApiResponse {
    @NonNull
    private List<IcdEntity> destinationEntities;
    private Boolean error;
    private Boolean resultChopped;
    private Boolean wordSuggestionsChopped;
    private Integer guessType;
    private String uniqueSearchId;
    private String words;
}
