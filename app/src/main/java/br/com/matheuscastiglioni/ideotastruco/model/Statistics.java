package br.com.matheuscastiglioni.ideotastruco.model;

import java.io.Serializable;

/**
 * Created by matheus on 26/08/17.
 */

public class Statistics implements Serializable {

    private String id;
    private String team;
    private int bo3;
    private int matchs;
    private int wins;
    private int loses;

    public Statistics(String id, String team, int bo3, int matchs, int wins, int loses) {
        this.id = id;
        this.team = team;
        this.bo3 = bo3;
        this.matchs = matchs;
        this.wins = wins;
        this.loses = loses;
    }

    public String getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public int getBo3() {
        return bo3;
    }

    public int getMatchs() {
        return matchs;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }
}
