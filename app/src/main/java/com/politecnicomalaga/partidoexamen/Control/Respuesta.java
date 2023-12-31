package com.politecnicomalaga.partidoexamen.Control;
import com.politecnicomalaga.partidoexamen.Model.Partido;
import java.util.LinkedList;
import java.util.List;
public class Respuesta {
    protected String datos;
    public Respuesta(String entrada) {
        datos = entrada;
    }
    public List<Partido> getData() {
        LinkedList<Partido> dataList = new LinkedList<>();
        String datosCortados = recortarAntes(datos,"1 Real Sociedad - Mallorca 1",2);
        String datosCortados2 = recortarDespues(datosCortados, "El ",1);
        String[] lines = datosCortados2.split("\n");
        String Temp = null;
        for (String line : lines
        ) {
            String[] parts = line.trim().split("\\s+");
                if (parts.length == 5) {
                    dataList.add(new Partido(parts[1], parts[3], parts[4]));
                }
                if (parts.length == 7) {
                    dataList.add(new Partido(parts[1] + " " + parts[2], parts[4] + " " + parts[5], parts[6]));
                }
                if (parts.length == 6) {
                    if (parts[2].equals("-")) {
                        dataList.add(new Partido(parts[1], parts[3] + " " + parts[4], parts[5]));
                    }
                    if (parts[3].equals("-")) {
                        dataList.add(new Partido(parts[1] + " " + parts[2], parts[4], parts[5]));
                    }
                }
                if (parts.length == 9)
                    dataList.add(new Partido(parts[3], parts[5], parts[6] + parts[7] + parts[8]));
            }
        return dataList;
    }
    public static String recortarAntes(String cadena, String palabra, int ocurrencia) {
        int inicio = 0;
        for (int i = 0; i < ocurrencia; i++) {
            inicio = cadena.indexOf(palabra, inicio + 1);
            if (inicio == -1) {
                return cadena;
            }
        }
        return cadena.substring(inicio);
    }

    public static String recortarDespues(String cadena, String palabra, int ocurrencia) {
        int inicio = 0;
        for (int i = 0; i < ocurrencia; i++) {
            inicio = cadena.indexOf(palabra, inicio + 1);
            if (inicio == -1) {
                return cadena;
            }
        }
        inicio = inicio + palabra.length();
        return cadena.substring(0, inicio);
    }
}
