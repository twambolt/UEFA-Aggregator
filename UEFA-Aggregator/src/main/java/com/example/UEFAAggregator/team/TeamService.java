package com.example.UEFAAggregator.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll(Sort.by(Sort.Direction.ASC, "rank"));
    }

    // get rid of this method later??
    public void addNewTeam(Team team) {
        Optional<Team> teamOptional = teamRepository
                .findTeamByTeamName(team.getTeamName());
        if (teamOptional.isPresent()){
            throw new IllegalStateException("Team Already Present");
        }
        teamRepository.save(team);
    }

    public void deleteTeam(String teamName){
        Optional<Team> teamOptional = teamRepository
                .findTeamByTeamName(teamName);
        if (teamOptional.isEmpty()) {
            throw new IllegalStateException("Team with name " + teamName + " does not exist in database");
        }
        teamRepository.delete(teamOptional.get());
    }

    @Transactional
    public void updateTeam(Integer teamId, Integer rank, Integer points){
        Team team = teamRepository
                .findTeamByTeamId(teamId)
                .orElseThrow(() -> new IllegalStateException("Team with id: "+ teamId + " does not exist"));

        if (rank != null && rank > 0 && rank != team.getRank()) {
            team.setRank(rank);
        }
        System.out.println(points);
        if (points != null && points > 0 && points > team.getPoints()){
            team.setPoints(points);
        }
    }
}
