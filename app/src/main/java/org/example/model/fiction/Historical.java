package org.example.model.fiction;

public class Historical extends FictionRecord {

    private String countryName;

    public Historical(String countryName) {
        super(FictionType.HISTORICAL);
        this.countryName = countryName;
    }

}
