package br.com.matheuscastiglioni.ideotastruco.validator;

import android.util.Log;
import android.widget.TextView;

import br.com.matheuscastiglioni.ideotastruco.type.OperatorType;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class Validator {

    public static boolean pontuationIsSmallerThenZero(Object pontuation) {
        return Integer.parseInt(pontuation.toString()) < 0;
    }

    public static boolean pontuationIsEqualsTwelve(Object pontuation) {
        return Integer.parseInt(pontuation.toString()) == 12;
    }

    public static boolean pontuationIsGreaterThenTwelve(Object pontuation) {
        return Integer.parseInt(pontuation.toString()) > 12;
    }

}
