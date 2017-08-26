package br.com.matheuscastiglioni.ideotastruco.type;

/**
 * Created by matheus on 16/08/17.
 */

public interface Operator {

    public int process();
    public Operator take(Object operator);
    public Operator next(Object operator);

}
