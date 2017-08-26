package br.com.matheuscastiglioni.ideotastruco.engine;

import android.widget.TextView;

import br.com.matheuscastiglioni.ideotastruco.factory.OperatorFactory;
import br.com.matheuscastiglioni.ideotastruco.model.Number;
import br.com.matheuscastiglioni.ideotastruco.validator.Validator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class Engine {

    public static String process(Object pontuation, TextView score) {
        int result = Integer.parseInt(score.getText().toString());
        String operator = getOperator(pontuation);
        result = OperatorFactory.findOperatorTo(new Number(result), new Number(getNumber(pontuation)), operator).process();
        return Integer.toString(result);
    }

    private static String getOperator(Object pontuation) {
        return pontuation.toString().substring(0, 1);
    }

    private static int getNumber(Object pontuation) {
        return Integer.parseInt(pontuation.toString().substring(1));
    }

}
