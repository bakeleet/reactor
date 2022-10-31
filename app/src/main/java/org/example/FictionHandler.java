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

    private FictionRecord sciFi = new ScienceFiction("Large Magellanic Cloud");
    private FictionRecord fantasy = new Fantasy("Geralt");
    private FictionRecord history = new Historical("Ukraine");

    private final List<FictionRecord> fictions = new ArrayList<>(
        Arrays.asList(sciFi, fantasy, history)
    );

    public Mono<FictionRecord> getRandomFiction() {
        var rand = new Random();
        var randomFiction = fictions.get(rand.nextInt(fictions.size()));
        return Mono.just(randomFiction)
                .delayElement(Duration.ofMillis(rand.nextInt(500)));
    }

    public Flux<FictionRecord> getAllFictionInRandomOrder() {
        Collections.shuffle(fictions);
        return Flux.fromIterable(fictions)
                .delayElements(Duration.ofMillis(250));
    }

    public Mono<FictionRecord> getScienceFiction() {
        return Mono.just(sciFi)
                .delayElement(Duration.ofMillis(new Random().nextInt(500)));
    }

    public Mono<FictionRecord> getFantasy() {
        return Mono.just(fantasy)
                .delayElement(Duration.ofMillis(new Random().nextInt(500)));
    }

    public Mono<FictionRecord> getHistorical() {
        return Mono.just(history)
                .delayElement(Duration.ofMillis(new Random().nextInt(500)));
    }

}
