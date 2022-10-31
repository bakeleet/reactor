package org.example.model.nonfiction;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Biography extends NonfictionRecord {

    private String personName;

    public Biography(String personName) {
        super(NonfictionType.BIOGRAPHY);
        this.personName = personName;
    }

}
