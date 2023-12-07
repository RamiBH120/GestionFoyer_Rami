package tn.esprit.gestionfoyer_rami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GestionFoyerRamiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionFoyerRamiApplication.class, args);
    }

}
