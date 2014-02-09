package de.fanero.example.akka;

import com.google.inject.Inject;
import de.fanero.example.akka.guice.GuiceUntypedActor;

public class ChildActor extends GuiceUntypedActor {

    private MyService myService;

    @Inject
    public ChildActor(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();

        myService.doSomething("ChildActor");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        unhandled(message);
    }
}
