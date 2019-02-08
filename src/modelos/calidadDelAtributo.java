/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author anlesvavor
 */
public class calidadDelAtributo {
    private double rank;
    private int indice;
    private String nombre;

    public calidadDelAtributo() {
    }

    public calidadDelAtributo(double rank, int indice, String nombre) {
        this.rank = rank;
        this.indice = indice;
        this.nombre = nombre;
    }
    
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
