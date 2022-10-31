package org.example.model.fiction;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScienceFiction extends FictionRecord {

    private String galaxyName;

    public ScienceFiction(String galaxyName) {
        super(FictionType.SCIENCE_FICTION);
        this.galaxyName = galaxyName;
    }

}
