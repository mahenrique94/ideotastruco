package br.com.matheuscastiglioni.ideotastruco.operator;

import br.com.matheuscastiglioni.ideotastruco.model.Number;
import br.com.matheuscastiglioni.ideotastruco.type.Operator;

/**
 * Created by matheus on 17/08/17.
 */

public class Subtract implements Operator {

    private final Operator left;
    private final Operator right;

    public Subtract(Operator left, Operator right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int process() {
        return this.left.process() - this.right.process();
    }

    @Override
    public Operator take(Object operator) {
        if (operator.toString().equals("-"))
            return this;
        return next(operator);
    }

    @Override
    public Operator next(Object operator) {
        return new Number(0).take(operator);
    }

}
