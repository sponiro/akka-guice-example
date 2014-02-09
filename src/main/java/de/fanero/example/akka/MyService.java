package de.fanero.example.akka;

public class MyService {

    public void doSomething(String message) {
        System.out.println(String.format("Service called from %1s", message));
    }
}
