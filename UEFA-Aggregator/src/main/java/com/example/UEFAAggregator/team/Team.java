package com.example.UEFAAggregator.team;

import javax.persistence.*;

@Entity
@Table
public class Team {

    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )

    private Integer teamId;
    private String teamName;
    private Integer leagueId;
    private int rank;
    private int points;




    public Team() {
    }

    public Team(String teamName, int teamId, int rank, int points, Integer leagueId) {
        this.teamName = teamName;
        this.teamId = teamId;
        this.rank = rank;
        this.points = points;
        this.leagueId = leagueId;
    }

    public Team(String teamName, int rank, int points) {
        this.teamName = teamName;
        this.rank = rank;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public int getRank() {
        return rank;
    }

    public int getPoints() {
        return points;
    }

    public Integer getLeagueId() {
        return leagueId;
    }



    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamId=" + teamId +
                ", rank=" + rank +
                ", points=" + points +
                '}';
    }
}
