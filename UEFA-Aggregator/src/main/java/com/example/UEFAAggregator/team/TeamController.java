package com.example.UEFAAggregator.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teams")
public class TeamController {

    public final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    public void addNewTeam(@RequestBody Team team){
        teamService.addNewTeam(team);
    }

    @DeleteMapping(path = "{teamName}")
    public void deleteTeamByName(@PathVariable("teamName") String teamName){
        teamService.deleteTeam(teamName);
    }

    @PutMapping(path = "{teamId}")
    public void updateTeamRank(
            @PathVariable("teamId") Integer teamId,
            @RequestParam(required = false) Integer rank,
            @RequestParam(required = false) Integer points) {
        teamService.updateTeam(teamId, rank, points);
    }

}
