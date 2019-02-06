package hellospring.task1;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class RndFileWriter {

    private static final String FILE_NAME = "rnd.txt";
    private FileWriter fileWriter;
    private boolean isFileOpened = false;

    @PostConstruct
    public void onInit(){
        try{
            fileWriter = new FileWriter(FILE_NAME);
            isFileOpened = true;
        }
        catch (IOException exc){
            System.out.println(String.format("RndFileWriter - IO Exception occurred: %s", exc.getMessage()));
        }
    }

    @Async
    @EventListener
    public void asyncHandleEvent(RndInfo event){

        if(!isFileOpened){
            System.out.println("File wasn't opened");
            return;
        }

        try{
            fileWriter.write(String.format("%s %s \n", event.getEventTime(), event.getValue()));
        }
        catch (IOException exc){
            System.out.println(String.format("RndFileWriter - cant write to file: %s", exc.getMessage()));
        }
    }


    @PreDestroy
    public void onDestroy(){
        if(isFileOpened)
        {
            try {
                fileWriter.flush();
                fileWriter.close();
                isFileOpened = false;
            }
            catch (IOException exc){
                System.out.println(String.format("RndFileWriter - cant close a file: %s", exc.getMessage()));
            }
        }
    }
}
