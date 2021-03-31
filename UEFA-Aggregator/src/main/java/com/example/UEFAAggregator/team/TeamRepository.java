package com.example.UEFAAggregator.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository
        extends JpaRepository<Team, Integer> {
// look out for the Integer choice there, int is being usd in the Team object

//    @Query("SELECT t FROM Team t WHERE t.teamName = ?1")
    Optional<Team> findTeamByTeamName(String teamName);

//    @Query("SELECT t FROM Team t WHERE t.teamId = ?1")
    Optional<Team> findTeamByTeamId(Integer teamId);

}
