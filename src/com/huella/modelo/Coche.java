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

public class Coche extends FuenteEmision {

    private double consumoCombustibleAnual;
    private double factorEmision;

    public Coche(String nombre, double consumoCombustibleAnual, double factorEmision) {
        super(nombre);
        this.consumoCombustibleAnual = consumoCombustibleAnual;
        this.factorEmision = factorEmision;
    }

    public double getConsumoCombustibleAnual() {
        return consumoCombustibleAnual;
    }

    public void setConsumoCombustibleAnual(double consumoCombustibleAnual) {
        this.consumoCombustibleAnual = consumoCombustibleAnual;
    }

    public double getFactorEmision() {
        return factorEmision;
    }

    public void setFactorEmision(double factorEmision) {
        this.factorEmision = factorEmision;
    }

    @Override
    public double calcularHuellaCarbono() {
        return consumoCombustibleAnual * factorEmision;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion()
                + " | Tipo: Coche"
                + " | Consumo Combustible: " + consumoCombustibleAnual
                + " | Factor Emisión: " + factorEmision;
    }
}