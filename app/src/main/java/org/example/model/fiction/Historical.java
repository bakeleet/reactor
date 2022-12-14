package org.example.model.fiction;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Historical extends FictionRecord {

    private String countryName;

    public Historical(String countryName) {
        super(FictionType.HISTORICAL);
        this.countryName = countryName;
    }

}
