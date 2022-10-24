package org.example;

import org.example.model.fiction.FictionRecord;
import org.example.model.interim.Action;
import org.example.model.interim.Break;
import org.example.model.interim.InterimState;
import org.example.model.interim.Transient;
import reactor.core.publisher.Mono;

public class FictionContext {

    private FictionHandler fictionHandler;

    private String metadata;

    private FictionRecord currentRecord;

    private InterimState currentState;

    public FictionContext(FictionHandler fictionHandler) {
        this.fictionHandler = fictionHandler;
        this.currentState = new Action(this.requestRandom());
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public FictionRecord getCurrentRecord() {
        return currentRecord;
    }

    public void setCurrentRecord(FictionRecord currentRecord) {
        this.currentRecord = currentRecord;
        this.currentState = switch (currentRecord.getType()) {
            case SCIENCE_FICTION -> new Transient(currentRecord.getType().name());
            case FANTASY -> new Action(this.requestRandom());
//                    case FANTASY -> new Action(
//                        Mono.fromCallable(() -> {
//                            return context.requestRandom();
//                            return null;
//                        })
//                    );
            case HISTORICAL -> new Break();
        };
    }

    public InterimState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(InterimState currentState) {
        this.currentState = currentState;
    }

    public void dispatchScienceFiction() {
        metadata = "science fiction";
        fictionHandler.printScienceFiction();
    }

    public Mono<FictionRecord> requestRandom() {
        metadata = "random";
        return fictionHandler.getRandomFiction();
    }

    public void dispatchFantasy() {
        metadata = "fantasy";
        fictionHandler.printFantasy();
    }

    public void dispatchHistorical() {
        metadata = "historical";
        fictionHandler.printHistorical();
    }

}
