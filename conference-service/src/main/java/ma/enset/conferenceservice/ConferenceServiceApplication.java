package ma.enset.conferenceservice;

import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.enums.Type;
import ma.enset.conferenceservice.repositories.ConferenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(
            ConferenceRepository conferenceRepository
    ){
        return args -> {
            List<String> keynotesIds = List.of("conference1","conference2","conference3");
            keynotesIds.forEach(pId->{
                Conference conference = Conference.builder()
                        .titre("conference")
                        .type(Type.COMMERCIALE)
                        .date(LocalDate.now())
                        .duree(new Random().nextInt(30))
                        .nombreInscrits((int)(Math.random()*1000))
                        .score((int)(Math.random()*100))
                        .build();
                conferenceRepository.save(conference);
            });
        };
    }
}
