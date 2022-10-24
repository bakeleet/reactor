package org.example.model.fiction;

public class ScienceFiction extends FictionRecord {

    private String galaxyName;

    public ScienceFiction(String galaxyName) {
        super(FictionType.SCIENCE_FICTION);
        this.galaxyName = galaxyName;
    }

}
