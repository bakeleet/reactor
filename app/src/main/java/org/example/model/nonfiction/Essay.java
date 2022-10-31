package org.example.model.nonfiction;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Essay extends NonfictionRecord {

    private String topicName;

    public Essay(String topicName) {
        super(NonfictionType.ESSAY);
        this.topicName = topicName;
    }

}
