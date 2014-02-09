package de.fanero.example.akka;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class AkkaModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TopActor.class).in(Scopes.NO_SCOPE);
        bind(MyService.class);
    }
}
