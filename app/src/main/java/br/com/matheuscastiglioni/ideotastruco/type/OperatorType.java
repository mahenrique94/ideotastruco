package br.com.matheuscastiglioni.ideotastruco.type;

/**
 * Created by matheus on 17/08/17.
 */

public enum OperatorType {

    SUM("+"),
    SUBTRACT("-"),
    MULTIPLY("x"),
    DIVIDE("/");

    private String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
