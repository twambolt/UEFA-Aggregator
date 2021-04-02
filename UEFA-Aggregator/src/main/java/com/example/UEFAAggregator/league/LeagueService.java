package com.example.UEFAAggregator.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// "Business service" layer

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getLeagues(){return leagueRepository.findAll();}

    public void addNewLeague(League league) {
        Optional<League> leagueOptional = leagueRepository
                .findLeagueByLeagueId(league.getLeagueId());
        if (leagueOptional.isPresent()){
            throw new IllegalStateException("League already present");
        }
        leagueRepository.save(league);
    }

    public void deleteLeague(String leagueName){
        Optional<League> leagueOptional = leagueRepository
                .findLeagueByLeagueName(leagueName);
        if (leagueOptional.isEmpty()){
            throw new IllegalStateException("League with name " + leagueName + " does not exist in database");
        }
        leagueRepository.delete(leagueOptional.get());
    }

}
