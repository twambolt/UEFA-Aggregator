package com.example.UEFAAggregator.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/leagues")
public class LeagueController {

    public final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public List<League> getLeagues() {
        return leagueService.getLeagues();
    }

    @PostMapping
    public void addNewLeague(@RequestBody League league){
        leagueService.addNewLeague(league);
    }

    @DeleteMapping(path = "{leagueName}")
    public void deleteLeagueByName(@PathVariable("leagueName") String leagueName){
        leagueService.deleteLeague(leagueName);
    }
}
