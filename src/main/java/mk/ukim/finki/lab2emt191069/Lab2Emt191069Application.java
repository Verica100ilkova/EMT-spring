package mk.ukim.finki.lab2emt191069;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab2Emt191069Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab2Emt191069Application.class, args);
    }

}
