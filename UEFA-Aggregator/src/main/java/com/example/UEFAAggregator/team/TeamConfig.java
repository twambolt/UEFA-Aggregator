package com.example.UEFAAggregator.team;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeamConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            TeamRepository teamRepository) {
        return args -> {
            Team realMadrid = new Team(
                    "Real Madrid",
                    1,
                    100);
            Team barca = new Team(
                            "Barcelona",
                            2,
                            90);
            teamRepository.saveAll(
                    List.of(realMadrid, barca)
            );
        };
    }

}
