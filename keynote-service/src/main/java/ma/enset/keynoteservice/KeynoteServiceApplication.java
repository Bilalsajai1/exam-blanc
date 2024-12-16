package ma.enset.keynoteservice;

import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository){
        return args -> {
            keynoteRepository.save(Keynote.builder().id("k01").nom("nom1").prenom("prenom1").email("k1@gmail.com").fonction("SPEAKER").build());
            keynoteRepository.save(Keynote.builder().id("k02").nom("nom2").prenom("prenom2").email("k2@gmail.com").fonction("ORGANIZER").build());
            keynoteRepository.save(Keynote.builder().id("k03").nom("nom3").prenom("prenom3").email("k3@gmail.com").fonction("MODERATOR").build());
        };

    }
}
