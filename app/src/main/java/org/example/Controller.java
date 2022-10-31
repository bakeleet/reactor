package org.example;

import org.example.model.fiction.FictionRecord;
import org.example.model.interim.Action;
import org.example.model.interim.Break;
import org.example.model.interim.InterimState;
import org.example.model.interim.Transient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Controller {

    private FictionHandler fictionHandler = new FictionHandler();
    private NonfictionHandler nonfictionHandler = new NonfictionHandler();
    private LiteraryContext context = new LiteraryContext(fictionHandler, nonfictionHandler);

    public Mono<String> getSomeFiction() {
        return fictionHandler
                .getRandomFiction()
                .map(this::mapRecord);
//            return Flux.generate(
//                () -> context.getCurrentState(),
//                (state, sink) -> {
//                    System.out.println("Current context metadata: " + context.getMetadata());
//                    sink.next(state);
//                    if (state instanceof Break) {
//                        sink.complete();
//                    }
//                    context.setCurrentState(state);
//                    return state;
//                });
//        var list = handler.getAllFictionInRandomOrder();
//        return list
//                .map(record -> switch (record.getType()) {
//                    case SCIENCE_FICTION -> new Transient(record.getType().name());
//                    case FANTASY -> new Action(context.requestRandom());
//                    case HISTORICAL -> new Break();
//                })
//                .takeUntil(state -> state instanceof Break)
//                .map(InterimState::handle);
    }

    public Mono<String> getFantasy() {
        return fictionHandler
                .getFantasy()
                .map(this::mapRecord);
    }

    public Mono<String> getScienceFiction() {
        return fictionHandler
                .getScienceFiction()
                .map(this::mapRecord);
    }

    public Mono<String> getHistorical() {
        return fictionHandler
                .getHistorical()
                .map(this::mapRecord);
    }

    private String mapRecord(FictionRecord record) {
        context.setCurrentRecord(record);
        System.out.println("CONTROLLER: record type = " + record.getType());

        var state = switch (record.getType()) {
            case SCIENCE_FICTION -> new Transient(record.getType().name());
            case FANTASY -> new Action(context.requestRandom());
            case HISTORICAL -> new Break();
        };
        System.out.println("CONTROLLER: state type = " + state.getType());
        context.setCurrentState(state);

        return context.getMetadata();
    }

//    public Mono<String> getSingleRecord() {
//        return fictionHandler.getRandomFiction()
//                .map(record -> {
//                    switch (record.getType()) {
//                        case FANTASY -> context.dispatchFantasy();
//                        case HISTORICAL -> context.dispatchHistorical();
//                        case SCIENCE_FICTION -> context.dispatchScienceFiction();
//                    }
//                    return context.getMetadata();
//                });
//    }

}
