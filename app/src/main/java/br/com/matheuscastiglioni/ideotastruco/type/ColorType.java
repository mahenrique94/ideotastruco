package br.com.matheuscastiglioni.ideotastruco.type;

/**
 * Created by matheus on 26/08/17.
 */

public enum ColorType {

    ERROR(0xFFFF8080),
    SUCCESS(0xFF00CC99);

    private int color;

    ColorType(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

}
