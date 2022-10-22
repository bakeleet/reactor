package org.example;

import org.example.model.fiction.FictionRecord;
import reactor.core.publisher.Mono;

public class FictionController {

    private FictionHandler handler = new FictionHandler();
    private FictionContext context = new FictionContext(handler);

    private Mono<FictionRecord> getMeSomeFiction() {
        return handler.getRandomFiction();
    }

    public Mono<String> endpoint() {
        return getMeSomeFiction().map(record -> {
            switch (record.getType()) {
                case FANTASY -> context.dispatchFantasy();
                case HISTORICAL -> context.dispatchHistorical();
                case SCIENCE_FICTION -> context.dispatchScienceFiction();
            }
            return context.getMetadata();
        });
    }

}
