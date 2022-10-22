package org.example.model.fiction;

public class FictionHistorical extends FictionRecord {

    private String countryName;

    public FictionHistorical(String countryName) {
        super(FictionType.HISTORICAL);
        this.countryName = countryName;
    }

}
