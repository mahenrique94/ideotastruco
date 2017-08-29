package br.com.matheuscastiglioni.ideotastruco.view;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import br.com.matheuscastiglioni.ideotastruco.R;
import br.com.matheuscastiglioni.ideotastruco.helper.DialogHelper;
import br.com.matheuscastiglioni.ideotastruco.model.Statistics;
import br.com.matheuscastiglioni.ideotastruco.type.TeamType;
import br.com.matheuscastiglioni.ideotastruco.validator.Validator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class View {

    public static void initStatisticsTeamA(Statistics statistics, Activity activity) {
        setBo3(statistics.getBo3(), (TextView) activity.findViewById(R.id.tvMain_bo3TeamA), activity);
        setMatchs(statistics.getMatchs(), (TextView) activity.findViewById(R.id.tvMain_matchsTeamA), activity);
        setWins(statistics.getWins(), (TextView) activity.findViewById(R.id.tvMain_victoriesTeamA), activity);
        setLoses(statistics.getLoses(), (TextView) activity.findViewById(R.id.tvMain_losesTeamA), activity);
    }

    public static void initStatisticsTeamB(Statistics statistics, Activity activity) {
        setBo3(statistics.getBo3(), (TextView) activity.findViewById(R.id.tvMain_bo3TeamB), activity);
        setMatchs(statistics.getMatchs(), (TextView) activity.findViewById(R.id.tvMain_matchsTeamB), activity);
        setWins(statistics.getWins(), (TextView) activity.findViewById(R.id.tvMain_victoriesTeamB), activity);
        setLoses(statistics.getLoses(), (TextView) activity.findViewById(R.id.tvMain_losesTeamB), activity);
    }

    public static void setBo3(int bo3, TextView textView, Activity activity) {
        textView.setText(String.format("%s %d", activity.getResources().getString(R.string.label_infoBO3), bo3));
    }

    public static void setMatchs(int matchs, TextView textView, Activity activity) {
        textView.setText(String.format("%s %d", activity.getResources().getString(R.string.label_infoMatchs), matchs));
    }

    public static void setWins(int wins, TextView textView, Activity activity) {
        textView.setText(String.format("%s %d", activity.getResources().getString(R.string.label_infoVictories), wins));
    }

    public static void setLoses(int loses, TextView textView, Activity activity) {
        textView.setText(String.format("%s %d", activity.getResources().getString(R.string.label_infoLoses), loses));
    }

    public static void setResult(Statistics statisticsTeamA, Statistics statisticsTeamB, TextView score, Object pontuation, String team, Context context, Activity activity) {
        if (Validator.pontuationIsSmallerThenZero(pontuation)) {
            score.setText("0");
        } else if (Validator.pontuationIsGreaterThenTwelve(pontuation) || Validator.pontuationIsEqualsTwelve(pontuation)) {
            score.setText("12");
            if (team.equals("A")) {
                statisticsTeamA.winner();
                statisticsTeamB.loser();
            } else {
                statisticsTeamB.winner();
                statisticsTeamA.loser();
            }
            statisticsTeamA.matchFinished();
            statisticsTeamB.matchFinished();
            updateStatistics(statisticsTeamA, statisticsTeamB, activity);
            DialogHelper.build(context, activity);
        } else {
            score.setText(pontuation.toString());
        }
    }

    public static void updateStatistics(Statistics statisticsTeamA, Statistics statisticsTeamB, Activity activity) {
        initStatisticsTeamA(statisticsTeamA, activity);
        initStatisticsTeamB(statisticsTeamB, activity);
    }

}
