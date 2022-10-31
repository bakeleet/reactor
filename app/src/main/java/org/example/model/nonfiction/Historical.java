package org.example.model.nonfiction;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Historical extends NonfictionRecord {

    private String countryName;

    public Historical(String countryName) {
        super(NonfictionType.HISTORICAL);
        this.countryName = countryName;
    }

}
