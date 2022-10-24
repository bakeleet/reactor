package org.example.model.fiction;

public class Fantasy extends FictionRecord {

    private String heroName;

    public Fantasy(String heroName) {
        super(FictionType.FANTASY);
        this.heroName = heroName;
    }

}
