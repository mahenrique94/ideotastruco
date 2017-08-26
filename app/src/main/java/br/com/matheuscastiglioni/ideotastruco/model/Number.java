package br.com.matheuscastiglioni.ideotastruco.model;

import br.com.matheuscastiglioni.ideotastruco.type.Operator;

/**
 * Created by matheus on 16/08/17.
 */

public class Number implements Operator {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int process() {
        return this.number;
    }

    @Override
    public Operator take(Object operator) {
        return next(operator);
    }

    @Override
    public Operator next(Object operator) {
        throw new RuntimeException("Operator has been not found");
    }
}
