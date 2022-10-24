package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.model.fiction.FictionRecord;
import org.example.model.interim.Action;
import org.example.model.interim.Break;
import org.example.model.interim.InterimState;
import org.example.model.interim.Transient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Controller {

    private FictionHandler handler = new FictionHandler();
    private FictionContext context = new FictionContext(handler);

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class FibonacciState {
        private int former;
        private int latter;
    }

    public Flux<Integer> getFibonacci(int limit) {
        return Flux.generate(
                () -> new FibonacciState(0, 1),
                (state, sink) -> {
                    System.out.println("Generating number: " + state);
                    sink.next(state.getFormer());
                    if (state.getLatter() > limit) {
                        sink.complete();
                    }
                    int temp = state.getFormer();
                    state.setFormer(state.getLatter());
                    state.setLatter(temp + state.getLatter());
                    return state;
                });
    }

    public Flux<InterimState> getAllFiction() {
//        return handler.getRandomFiction().map(record -> {
//            var state = switch (record.getType()) {
//                case SCIENCE_FICTION -> new Transient(record.getType().name());
//                case FANTASY -> new Action(context.requestRandom());
////                    case FANTASY -> new Action(
////                        Mono.fromCallable(() -> {
////                            return context.requestRandom();
////                            return null;
////                        })
////                    );
//                case HISTORICAL -> new Break();
////            };
//            context.setCurrentState(state);
//        });
            return Flux.generate(
                () -> context.getCurrentState(),
                (state, sink) -> {
                    System.out.println("Current context metadata: " + context.getMetadata());
                    sink.next(state);
                    if (state instanceof Break) {
                        sink.complete();
                    }
                    context.setCurrentState(state);
                    return state;
                });
//        var list = handler.getAllFictionInRandomOrder();
//        return list
//                .map(record -> switch (record.getType()) {
//                    case SCIENCE_FICTION -> new Transient(record.getType().name());
//                    case FANTASY -> new Action(context.requestRandom());
////                    case FANTASY -> new Action(
////                        Mono.fromCallable(() -> {
////                            return context.requestRandom();
//////                            return null;
////                        })
////                    );
//                    case HISTORICAL -> new Break();
//                })
//                .takeUntil(state -> state instanceof Break)
//                .map(InterimState::handle);
    }

//    public Mono<String> getSingleRecord() {
//        return handler.getRandomFiction()
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
