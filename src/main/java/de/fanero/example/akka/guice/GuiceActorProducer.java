package de.fanero.example.akka.guice;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import com.google.inject.Injector;

public class GuiceActorProducer implements IndirectActorProducer {

    private final Injector injector;
    private Class<? extends Actor> actorClass;

    public GuiceActorProducer(Injector injector, Class<? extends Actor> actorClass) {
        this.injector = injector;
        this.actorClass = actorClass;
    }

    @Override
    public Actor produce() {
        return injector.getInstance(actorClass);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return actorClass;
    }
}
