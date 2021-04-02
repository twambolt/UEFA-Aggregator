package com.example.UEFAAggregator.league;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LeagueConfig {

    @Bean
    CommandLineRunner commandLineRunnerLeague(LeagueRepository leagueRepository){
        return args -> {
            League laLiga = new League("La Liga");
            League premierLeague = new League("English Premier League");

            leagueRepository.saveAll(
                    List.of(laLiga, premierLeague)
            );
        };
    }
}
