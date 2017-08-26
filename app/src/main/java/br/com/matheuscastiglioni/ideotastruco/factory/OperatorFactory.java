package br.com.matheuscastiglioni.ideotastruco.factory;

import br.com.matheuscastiglioni.ideotastruco.model.Number;
import br.com.matheuscastiglioni.ideotastruco.operator.Sum;
import br.com.matheuscastiglioni.ideotastruco.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public abstract class OperatorFactory {

    public static Operator findOperatorTo(Operator left, Operator right, Object operator) {
        return new Sum(left, right).take(operator);
    }

}
