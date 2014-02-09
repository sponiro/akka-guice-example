package de.fanero.example.akka;

import com.google.inject.Inject;
import de.fanero.example.akka.guice.GuiceUntypedActor;

public class TopActor extends GuiceUntypedActor {

    private MyService myService;

    @Inject
    public TopActor(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();

        // create child actor to show injection works here too
        getContext().actorOf(makeGuiceProps(ChildActor.class));

        myService.doSomething("TopActor");
    }

    @Override
    public void onReceive(Object message) throws Exception {

        unhandled(message);
    }
}
