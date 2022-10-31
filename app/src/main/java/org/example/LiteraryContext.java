package org.example;

import org.example.model.fiction.FictionRecord;
import org.example.model.interim.InterimState;
import reactor.core.publisher.Mono;

public class LiteraryContext {

    private FictionHandler fictionHandler;
    private NonfictionHandler nonfictionHandler;

    private String metadata;

    private FictionRecord currentRecord;

    private InterimState currentState;

    public LiteraryContext(FictionHandler fictionHandler, NonfictionHandler nonfictionHandler) {
        this.fictionHandler = fictionHandler;
        this.nonfictionHandler = nonfictionHandler;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setCurrentRecord(FictionRecord currentRecord) {
        this.currentRecord = currentRecord;
    }

    public void setCurrentState(InterimState currentState) {
        this.currentState = currentState;
        this.metadata = currentState.handle();
    }

    public Mono<FictionRecord> requestRandom() {
        return fictionHandler.getRandomFiction();
    }

}
