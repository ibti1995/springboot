package autoagencyuser.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AutoAgencyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoAgencyUserApplication.class, args);
    }

}
