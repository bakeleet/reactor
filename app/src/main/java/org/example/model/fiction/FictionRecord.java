package org.example.model.fiction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.Record;

@AllArgsConstructor
@Getter
public class FictionRecord implements Record {

    private FictionType type;

}
