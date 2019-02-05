package hellospring.task1;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RndFileWriter {

    private static final String FILE_NAME = "rnd.txt";

    @Async
    @EventListener
    public void asyncHandleEvent(RndInfo event){

        try{
            FileWriter fileWriter = new FileWriter(FILE_NAME, true);
            try(PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(String.format("%s %s", event.getEventTime(), event.getValue()));
            }
        }
        catch (IOException exc){
            System.out.println(String.format("RndFileWriter - IO Exception occured: %s", exc.getMessage()));
        }

    }
}
