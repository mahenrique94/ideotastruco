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

    public Statistics() {
        this.bo3 = 0;
        this.matchs = 0;
        this.wins = 0;
        this.loses = 0;
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getBo3() {
        return bo3;
    }

    public void setBo3(int bo3) {
        this.bo3 = bo3;
    }

    public int getMatchs() {
        return matchs;
    }

    public void setMatchs(int matchs) {
        this.matchs = matchs;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void loser() {
        setLoses(getLoses() + 1);
    }

    public void matchFinished() {
        setMatchs(getMatchs() + 1);
        if (winBo3() && matchHasBeenEnded()) {
            setBo3(getBo3() + 1);
            setMatchs(0);
            setWins(0);
            setLoses(0);
        }
        if (loseBo3() && matchHasBeenEnded()) {
            setMatchs(0);
            setWins(0);
            setLoses(0);
        }
    }

    public void winner() {
        setWins(getWins() + 1);
    }

    private boolean winBo3() {
        return getWins() == 2;
    }

    private boolean loseBo3() {
        return getLoses() == 2;
    }

    private boolean matchHasBeenEnded() {
        return (getWins() + getLoses()) == 3 || getWins() == 2 || getLoses() == 2;
    }

}
