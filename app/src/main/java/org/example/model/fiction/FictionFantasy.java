package org.example.model.fiction;

public class FictionFantasy extends FictionRecord {

    private String heroName;

    public FictionFantasy(String heroName) {
        super(FictionType.FANTASY);
        this.heroName = heroName;
    }

}
