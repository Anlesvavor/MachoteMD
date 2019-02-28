/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelos.ListaModelos;
import modelos.Modelo;

/**
 *
 * @author anlesvavor
 */
public class VistaModelos extends JPanel {
    
    private ListaModelos modelos;
    private JLabel lblK;

    public VistaModelos(ListaModelos modelos) {
       this.modelos = modelos;
       actualizar();
    }

    public VistaModelos() {
    }
    
    
    
    public void actualizar() {
        removeAll();
        setLayout(new GridLayout(modelos.getModelos().size(), 1));
        VistaModelo.contador = 0;
       // modelos.getModelos().stream().forEach(modelo -> add(new VistaModelo(modelo)));
        
        for(Modelo modelo : modelos.getModelos()) {
            VistaModelo c = new VistaModelo(modelo);
            add(c);
        }
        
        updateUI();
    }
    
    public void cambiarMejor(Modelo modelo) {
        for (Modelo m : modelos.getModelos()) {
            if(modelo.equals(m)) {
                modelo.setMejor(true);
            }
            else {
                modelo.setMejor(false);
            }
        }
        //modelos.getModelos().stream().forEach(m -> modelo == m ? modelo.setMejor(Boolean.TRUE) : modelo.setMejor(Boolean.FALSE));
        actualizar();
    }

    void calcularK() {
        int seleccionados =0 ;
        Modelo m1 = null;
        Modelo m2 = null;
        for(Modelo modelo : modelos.getModelos()) {
            if( modelo.getSeleccionado()) {
                seleccionados++;
                if(m1 == null){ m1 = modelo; }
                else if(m2 == null) m2 = modelo;
            }
        }
        if (seleccionados == 2) {
            double k = 10;
            if(m2.getErrores() - m1.getErrores() != 0){
                
                k = (m2.getNumeroCondiciones() - m1.getNumeroCondiciones())
                        / (m1.getErrores() - m2.getErrores());
                if(m1.getNumeroCondiciones() > m2.getNumeroCondiciones()){
                    k--;
                }else{
                    k++;
                }
            }
            Modelo.setK(k);
            getLblK().setText(String.format("%10.2f", k));
            actualizar();
        }
        else {
            JOptionPane.showMessageDialog(null, "Debes de seleccionar  sólo dos medelos, existen "+ seleccionados + " modelos seleccionados");
        }
    }

    public ListaModelos getModelos() {
        return modelos;
    }

    public void setModelos(ListaModelos modelos) {
        this.modelos = modelos;
        actualizar();
    }

    public JLabel getLblK() {
        return lblK;
    }

    public void setLblK(JLabel lblK) {
        this.lblK = lblK;
    }
    
    
}
