package org.example;

import org.example.model.fiction.FictionFantasy;
import org.example.model.fiction.FictionHistorical;
import org.example.model.fiction.FictionRecord;
import org.example.model.fiction.FictionScienceFiction;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

public class FictionHandler {

    public Mono<FictionRecord> getRandomFiction() {
        var fictions = List.of(
                new FictionScienceFiction("Large Magellanic Cloud"),
                new FictionFantasy("Geralt"),
                new FictionHistorical("Ukraine")
        );
        var rand = new Random();
        var randomFiction = fictions.get(rand.nextInt(fictions.size()));
        return Mono.just(randomFiction);
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
