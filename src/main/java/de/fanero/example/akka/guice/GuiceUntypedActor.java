package de.fanero.example.akka.guice;

import akka.actor.Props;
import akka.actor.UntypedActor;
import com.google.inject.Injector;

public abstract class GuiceUntypedActor extends UntypedActor {

    public Injector getInjector() {
        return GuiceExtension.provider.get(getContext().system()).getInjector();
    }

    public Props makeGuiceProps(Class<?> clazz) {
        return Props.create(GuiceActorProducer.class, getInjector(), clazz);
    }
}
