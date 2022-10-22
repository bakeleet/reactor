package org.example.model.fiction;

public class FictionScienceFiction extends FictionRecord {

    private String galaxyName;

    public FictionScienceFiction(String galaxyName) {
        super(FictionType.SCIENCE_FICTION);
        this.galaxyName = galaxyName;
    }

}
