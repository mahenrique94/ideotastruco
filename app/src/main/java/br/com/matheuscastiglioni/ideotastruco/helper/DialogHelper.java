package br.com.matheuscastiglioni.ideotastruco.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.matheuscastiglioni.ideotastruco.R;
import br.com.matheuscastiglioni.ideotastruco.type.ColorType;
import br.com.matheuscastiglioni.ideotastruco.view.View;

/**
 * Created by matheus on 26/08/17.
 */

public abstract class DialogHelper {

    public static void build(final Context context, final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle("Fim de jogo");
        builder.setMessage("Deseja iniciar uma nova partida ?");
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                TextView scoreTeamA = activity.findViewById(R.id.tvMain_scoreTeamA);
                TextView scoreTeamB = activity.findViewById(R.id.tvMain_scoreTeamB);
                scoreTeamA.setText("0");
                scoreTeamB.setText("0");
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        alert.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ColorType.ERROR.getColor());
        alert.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ColorType.SUCCESS.getColor());
    }

    public static void buildeEditTeamName(Context context, Activity activity, TextView teamName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setView(R.layout.edit_name_team);
        AlertDialog alert = builder.create();
        alert.show();
        configureAlert(alert, teamName);
    }

    private static void configureAlert(AlertDialog alert, TextView teamName) {
        setTeamNameInEdit(alert, teamName);
        setCancelAction(alert);
        setConfirmAction(alert, teamName);
    }

    private static void setTeamNameInEdit(AlertDialog alert, TextView teamName) {
        EditText editTextTeamName = alert.findViewById(R.id.etEditNameTeam_name);
        editTextTeamName.setText(teamName.getText().toString());
    }

    private static void setCancelAction(final AlertDialog alert) {
        Button button = alert.findViewById(R.id.btnEditNameTeam_cancel);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                alert.hide();
            }
        });
    }

    private static void setConfirmAction(final AlertDialog alert, final TextView teamName) {
        Button button = alert.findViewById(R.id.btnEditNameTeam_confirm);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                EditText editTextTeamName = alert.findViewById(R.id.etEditNameTeam_name);
                teamName.setText(editTextTeamName.getText().toString());
                alert.hide();
            }
        });
    }

}
