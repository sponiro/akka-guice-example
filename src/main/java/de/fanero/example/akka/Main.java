package de.fanero.example.akka;

import akka.actor.ActorSystem;
import com.google.inject.Guice;
import com.google.inject.Injector;
import de.fanero.example.akka.guice.GuiceActorUtils;
import de.fanero.example.akka.guice.GuiceExtension;
import de.fanero.example.akka.guice.GuiceExtensionImpl;
import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final ActorSystem actorSystem = ActorSystem.create("akka-guice-example");
        actorSystem.registerExtension(GuiceExtension.provider);

        // configure Guice
        Injector injector = Guice.createInjector(new AkkaModule());
        GuiceExtensionImpl guiceExtension = GuiceExtension.provider.get(actorSystem);
        guiceExtension.setInjector(injector);

        // test actor on top level
        actorSystem.actorOf(GuiceActorUtils.makeProps(actorSystem, TopActor.class));

        actorSystem.scheduler().scheduleOnce(FiniteDuration.apply(3, TimeUnit.SECONDS), new Runnable() {
            @Override
            public void run() {
                actorSystem.shutdown();
            }
        }, actorSystem.dispatcher());
    }
}
