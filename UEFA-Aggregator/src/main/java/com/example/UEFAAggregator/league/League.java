package com.example.UEFAAggregator.league;

import javax.persistence.*;

// Definition of the League Table JPA object

@Entity
@Table
public class League {


    @Id
    @SequenceGenerator(
            name = "league_sequence",
            sequenceName = "league_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "league_sequence"
    )

    private Integer leagueId;
    private String leagueName;

    public League() {
    }

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    public League(Integer leagueId, String leagueName) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueName='" + leagueName + '\'' +
                ", leagueId=" + leagueId + '}';
    }
}
