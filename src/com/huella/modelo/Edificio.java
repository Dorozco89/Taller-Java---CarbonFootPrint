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

public class Edificio extends FuenteEmision {

    private double consumoEnergiaAnual;
    private double factorEmision;

    public Edificio(String nombre, double consumoEnergiaAnual, double factorEmision) {
        super(nombre);
        this.consumoEnergiaAnual = consumoEnergiaAnual;
        this.factorEmision = factorEmision;
    }

    public double getConsumoEnergiaAnual() {
        return consumoEnergiaAnual;
    }

    public void setConsumoEnergiaAnual(double consumoEnergiaAnual) {
        this.consumoEnergiaAnual = consumoEnergiaAnual;
    }

    public double getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(double factorEmision) {
        this.factorEmision = factorEmision;
    }

    @Override
    public double calcularHuellaCarbono() {
        return consumoEnergiaAnual * factorEmision;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() +
                " | Tipo: Edificio" +
                " | Consumo Energía: " + consumoEnergiaAnual +
                " | Factor Emisión: " + factorEmision;
    }
}