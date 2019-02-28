/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author anlesvavor
 */
public class ListaModelos {

    private ArrayList<Modelo> modelos;

    public ListaModelos() {
        modelos = new ArrayList<>();
    }

    public void add(Modelo modelo) {
        modelos.add(modelo);
    }
    
    public void ordenar() {
        Collections.sort(modelos);
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Modelo> modelos) {
        this.modelos = modelos;
    }
    
    

}
