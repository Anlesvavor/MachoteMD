/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

/**
 *
 * @author anlesvavor
 */
public class Modelo implements Serializable, Comparable<Modelo> {

    private static double K = 10;

    public static double getK() {
        return K;
    }

    public static void setK(double aK) {
        K = aK;
    }

    private double precision;
    private int numeroCondiciones;
    private int errores;
    private J48 modelo;
    
    private boolean seleccionado;
    private boolean mejor;

    public Modelo() {
    }

    public Modelo(J48 modelo, Instances datos) throws Exception {
        modelo.buildClassifier(datos);
        setModelo(modelo);
        Evaluation evaluador = new Evaluation(datos);
        evaluador.crossValidateModel(modelo, datos, 10, new Random(0));
        setErrores((int)evaluador.incorrect());
        setNumeroCondiciones((int)modelo.measureTreeSize() - 1 );
        setPrecision(evaluador.pctCorrect());
        setSeleccionado(false);
        setMejor(false);
    }

    public double getDML() {
        return getErrores() * getK() + getNumeroCondiciones();
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public int getNumeroCondiciones() {
        return numeroCondiciones;
    }

    public void setNumeroCondiciones(int numeroCondiciones) {
        this.numeroCondiciones = numeroCondiciones;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public J48 getModelo() {
        return modelo;
    }

    public void setModelo(J48 modelo) {
        this.modelo = modelo;
    }

    @Override
    public int compareTo(Modelo t) {
        return getDML() == t.getDML() ? 0 : getDML() > t.getDML() ? -1 : 1 ;
        
        //return (int)((getDML() - t.getDML()) * 100);
    }

    public boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isMejor() {
        return mejor;
    }

    public void setMejor(boolean mejor) {
        this.mejor = mejor;
    }

}
