package com.example.UEFAAggregator.league;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

    Optional<League> findLeagueByLeagueName(String leagueName);

    Optional<League> findLeagueByLeagueId(Integer leagueId);

}
