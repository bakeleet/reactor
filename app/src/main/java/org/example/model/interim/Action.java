package org.example.model.interim;

import org.example.model.fiction.FictionRecord;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;

public class Action extends InterimState {

    private Publisher<String> action;

    private Mono<FictionRecord> reactiveAction;

    public Action(Publisher<String> action) {
        super(InterimType.ACTION);
        this.action = action;
    }

    public Action(Mono<FictionRecord> reactiveAction) {
        super(InterimType.ACTION);
        this.reactiveAction = reactiveAction;
    }

    private static class ActionSubscriber implements Subscriber<String> {
        @Override
        public void onSubscribe(Subscription subscription) {
            subscription.request(1);
        }

        @Override
        public void onNext(String string) {
//            onNext(string);
//            System.out.println("ActionSubscriber.onNext: " + string);
        }

        @Override
        public void onError(Throwable t) {
//            onError(t);
//            System.out.println("ActionSubscriber.onError: " + t.getMessage());
        }

        @Override
        public void onComplete() {
//            onComplete();
//            System.out.println("ActionSubscriber.onComplete");
        }
    }

    @Override
    public String handle() {
//        action.subscribe(new ActionSubscriber());
        reactiveAction.subscribe();
        return "action";
    }

}
