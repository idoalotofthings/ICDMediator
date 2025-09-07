package io.github.justincodinguk.icdmediator.model;

import lombok.Data;

import java.util.List;


@Data
public class IcdEntity {
    private String id;
    private String title;
    private String stemId;
    private boolean isLeaf;
    private int postcoordinationAvailability;
    private boolean hasCodingNote;
    private boolean hasMaternalChapterLink;
    private boolean hasPerinatalChapterLink;
    private List<MatchingPv> matchingPVs;
    private boolean propertiesTruncated;
    private boolean isResidualOther;
    private boolean isResidualUnspecified;
    private String chapter;
    private String theCode;
    private double score;
    private boolean titleIsASearchResult;
    private boolean titleIsTopScore;
    private int entityType;
    private boolean important;
    private List<Object> descendants;
}

@Data
class MatchingPv {
    private String propertyId;
    private String label;
    private double score;
    private boolean important;
    private String foundationUri;
    private int propertyValueType;
}
