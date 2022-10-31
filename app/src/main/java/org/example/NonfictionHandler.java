package org.example;

import org.example.model.nonfiction.Biography;
import org.example.model.nonfiction.Essay;
import org.example.model.nonfiction.Historical;
import org.example.model.nonfiction.NonfictionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.*;

public class NonfictionHandler {

    private final List<NonfictionRecord> nonfictions = new ArrayList<>(
        Arrays.asList(
            new Biography("Albert Einstein"),
            new Essay("Global warming"),
            new Historical("Poland")
        )
    );

    public Mono<NonfictionRecord> getRandomNonfiction() {
        var rand = new Random();
        return Mono.just(nonfictions.get(rand.nextInt(nonfictions.size())))
                .delayElement(Duration.ofMillis(rand.nextInt(500)));
    }

    public Flux<NonfictionRecord> getAllNonfictionInRandomOrder() {
        Collections.shuffle(nonfictions);
        return Flux.fromIterable(nonfictions)
                .delayElements(Duration.ofMillis(250));
    }

    public void printBiography() {
        System.out.println("dispatched task: biography");
    }

    public void printEssay() {
        System.out.println("dispatched task: essay");
    }

    public void printHistorical() {
        System.out.println("dispatched task: historical");
    }

}
