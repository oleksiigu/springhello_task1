package hellospring.task1;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RndConsoleWriter {

    @EventListener
    public void syncHandleEvent(RndInfo event){
        System.out.println(String.format("Rnd %s %s", event.getEventTime(), event.getValue()));
    }
}
