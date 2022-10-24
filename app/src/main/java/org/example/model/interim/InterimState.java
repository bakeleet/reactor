package org.example.model.interim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.Record;

@AllArgsConstructor
@Getter
public abstract class InterimState implements Record {

    private InterimType type;

    public abstract String handle();

}
