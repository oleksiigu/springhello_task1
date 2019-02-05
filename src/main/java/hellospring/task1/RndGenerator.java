package hellospring.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.Random;

@Component
public class RndGenerator {

    private static final int UPPER_BOUND = 100;
    private Random randomGenerator;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostConstruct
    private void init(){
        randomGenerator = new Random();
        printWithTime("Object created");
    }

    @PreDestroy
    private void destroy(){
        printWithTime("Object destroyed");
    }

    // Generates random value each second
    @Scheduled(fixedRate = 1000)
    public void generateRandomValue(){
        RndInfo eventInfo = new RndInfo(randomGenerator.nextInt(UPPER_BOUND));

        printWithTime(String.format("New value published: %s ", eventInfo.getValue()));
        publisher.publishEvent(eventInfo);
    }


    private void printWithTime(String message){
        System.out.println(String.format("RndGenerator - %s : %s", message, new Date().toString()));
    }
}
