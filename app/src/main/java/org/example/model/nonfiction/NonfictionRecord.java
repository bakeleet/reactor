package org.example.model.nonfiction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.Record;

@AllArgsConstructor
@Getter
public class NonfictionRecord implements Record {

    private NonfictionType type;

}
