/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package com.huella.app;

import com.huella.modelo.*;
import com.huella.servicio.GestorArchivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AplicacionHuellaCarbono {

    private List<HuellaDeCarbono> fuentes;
    private final GestorArchivos gestorArchivos;

    public AplicacionHuellaCarbono() {
        fuentes = new ArrayList<>();
        gestorArchivos = new GestorArchivos();
    }

    public void inicializarDatos() {
        fuentes.add(new Edificio("Edificio Central", 15000, 0.5));
        fuentes.add(new Coche("Coche Familiar", 1200, 2.3));
        fuentes.add(new Bicicleta("Bicicleta Urbana", 3000));
    }

    public void mostrarHuellas() {
        fuentes.stream().map((fuente) -> {
            System.out.println(fuente.obtenerDescripcion());
            return fuente;
        }).map((fuente) -> {
            System.out.println("Huella de Carbono: " + fuente.calcularHuellaCarbono());
            return fuente;
        }).forEachOrdered((_item) -> {
            System.out.println("--------------------------------------");
        });
    }

    public void guardarObjetos(String ruta) {
        try {
            gestorArchivos.guardarObjetos(ruta, fuentes);
            System.out.println("Objetos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarObjetos(String ruta) {
        try {
            fuentes = gestorArchivos.leerObjetos(ruta);
            System.out.println("Objetos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        AplicacionHuellaCarbono app = new AplicacionHuellaCarbono();

        String ruta = "objetos_huella.txt";

        app.inicializarDatos();

        System.out.println("=== DATOS ORIGINALES ===");
        app.mostrarHuellas();

        app.guardarObjetos(ruta);

        app.cargarObjetos(ruta);

        System.out.println("=== DATOS RECUPERADOS ===");
        app.mostrarHuellas();
    }
}