/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package com.huella.modelo;

public class Bicicleta extends FuenteEmision {

    private double kilometrosAnuales;

    public Bicicleta(String nombre, double kilometrosAnuales) {
        super(nombre);
        this.kilometrosAnuales = kilometrosAnuales;
    }

    public double getKilometrosAnuales() {
        return kilometrosAnuales;
    }

    public void setKilometrosAnuales(double kilometrosAnuales) {
        this.kilometrosAnuales = kilometrosAnuales;
    }

    @Override
    public double calcularHuellaCarbono() {
        return 0.0;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion()
                + " | Tipo: Bicicleta"
                + " | Kilómetros Anuales: " + kilometrosAnuales;
    }
}
