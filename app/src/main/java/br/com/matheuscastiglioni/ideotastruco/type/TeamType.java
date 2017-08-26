package br.com.matheuscastiglioni.ideotastruco.type;

/**
 * Created by matheus on 26/08/17.
 */

public enum TeamType {

    TEAM("", ""),
    TEAMA("A", "B"),
    TEAMB("B", "A");

    private String team;
    private String enemy;

    TeamType(String team, String enemy) {
        this.team = team;
        this.enemy = enemy;
    }

    public String getTeam() {
        return team;
    }

    public String getEnemy() {
        return enemy;
    }

    public TeamType getTeam(String team) {
        for (TeamType t : values()) {
            if (t.getTeam().equals(team))
                return t;
        }
        return null;
    }
}
