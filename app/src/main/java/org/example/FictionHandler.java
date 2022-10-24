package org.example;

import org.example.model.fiction.Fantasy;
import org.example.model.fiction.Historical;
import org.example.model.fiction.FictionRecord;
import org.example.model.fiction.ScienceFiction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.*;

public class FictionHandler {

    private final List<FictionRecord> fictions = new ArrayList<>(
        Arrays.asList(
            new ScienceFiction("Large Magellanic Cloud"),
            new Fantasy("Geralt"),
            new Historical("Ukraine")
        )
    );

    public Mono<FictionRecord> getRandomFiction() {
        var randomNumber = new Random().nextInt(fictions.size());
        var randomFiction = fictions.get(randomNumber);
        return Mono.just(randomFiction)
                .delayElement(Duration.ofMillis(250));
    }

    public Flux<FictionRecord> getAllFictionInRandomOrder() {
//        Collections.shuffle(fictions);
        return Flux.fromIterable(fictions)
                .delayElements(Duration.ofMillis(1000));
    }

    public void printScienceFiction() {
        System.out.println("dispatched task: science fiction");
    }

    public void printFantasy() {
        System.out.println("dispatched task: fantasy");
    }

    public void printHistorical() {
        System.out.println("dispatched task: science fiction");
    }

}
