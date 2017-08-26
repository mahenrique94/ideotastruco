package br.com.matheuscastiglioni.ideotastruco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import br.com.matheuscastiglioni.ideotastruco.dao.DAO;
import br.com.matheuscastiglioni.ideotastruco.engine.Engine;
import br.com.matheuscastiglioni.ideotastruco.helper.DialogHelper;
import br.com.matheuscastiglioni.ideotastruco.model.Statistics;
import br.com.matheuscastiglioni.ideotastruco.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvMain_scoreTeamA)
    TextView textViewScoreTeamA;
    @BindView(R.id.tvMain_scoreTeamB)
    TextView textViewScoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DAO dao = new DAO(this);
        View.initStatisticsTeamA(dao.getStatistics("A"), this);
        View.initStatisticsTeamB(dao.getStatistics("B"), this);
    }

    @OnClick({
        R.id.btnMain_minusOneTeamA,
        R.id.btnMain_minusThreeTeamA,
        R.id.btnMain_minusSixTeamA,
        R.id.btnMain_minusNineTeamA,
        R.id.btnMain_minusTwelveTeamA,
        R.id.btnMain_moreOneTeamA,
        R.id.btnMain_moreThreeTeamA,
        R.id.btnMain_moreSixTeamA,
        R.id.btnMain_moreNineTeamA,
        R.id.btnMain_moreTwelveTeamA,
    })
    public void pontuationTeamA(Button pontuation) {
        View.setResult(this.textViewScoreTeamA, Engine.process(pontuation.getText().toString(), this.textViewScoreTeamA), "A", this, this);
    }

    @OnClick({
        R.id.btnMain_minusOneTeamB,
        R.id.btnMain_minusThreeTeamB,
        R.id.btnMain_minusSixTeamB,
        R.id.btnMain_minusNineTeamB,
        R.id.btnMain_minusTwelveTeamB,
        R.id.btnMain_moreOneTeamB,
        R.id.btnMain_moreThreeTeamB,
        R.id.btnMain_moreSixTeamB,
        R.id.btnMain_moreNineTeamB,
        R.id.btnMain_moreTwelveTeamB,
    })
    public void pontuationTeamB(Button pontuation) {
        View.setResult(this.textViewScoreTeamB, Engine.process(pontuation.getText().toString(), this.textViewScoreTeamB), "B", this, this);
    }

    @OnClick({
        R.id.tvMain_nameTeamA,
        R.id.tvMain_nameTeamB
    })
    public void editNameTeamA(TextView teamName) {
        DialogHelper.buildeEditTeamName(this, this, teamName);
    }

}
