package com.politecnicomalaga.partidoexamen.Model;

public class Partido {
    private String Equipo1;
    private String Equipo2;
    private String Resultado;
    public Partido(String Equipo1, String Equipo2, String Resultado) {
        this.Equipo1 = Equipo1;
        this.Equipo2 = Equipo2;
        this.Resultado = Resultado;
    }
    public String getEquipo1() {
        return Equipo1;
    }
    public String getEquipo2() {
        return Equipo2;
    }
    public String getResultado() {
        return Resultado;
    }
}
