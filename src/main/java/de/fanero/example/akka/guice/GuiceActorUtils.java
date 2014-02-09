package de.fanero.example.akka.guice;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.google.inject.Injector;

public class GuiceActorUtils {

    public static Injector getInjector(ActorSystem actorSystem) {
        return GuiceExtension.provider.get(actorSystem).getInjector();
    }

    public static Props makeProps(ActorSystem actorSystem, Class<?> clazz) {
        return Props.create(GuiceActorProducer.class, getInjector(actorSystem), clazz);
    }
}
