package org.example.model.interim;

import org.example.model.fiction.FictionRecord;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;

public class Action extends InterimState {

    private Mono<FictionRecord> action;

    public Action(Mono<FictionRecord> action) {
        super(InterimType.ACTION);
        this.action = action;
    }

    @Override
    public String handle() {
        action.log().subscribe();
        return "action";
    }

}
