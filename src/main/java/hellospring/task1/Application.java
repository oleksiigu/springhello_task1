package hellospring.task1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.stream.Stream;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            Stream.of(context.getBeanDefinitionNames()).forEach(name -> System.out.println("Bean: " + name));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Main: interrupted");
            }
        }

    }
}
