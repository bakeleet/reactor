package org.example.model.fiction;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Fantasy extends FictionRecord {

    private String heroName;

    public Fantasy(String heroName) {
        super(FictionType.FANTASY);
        this.heroName = heroName;
    }

}
