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

import com.huella.modelo.HuellaDeCarbono;
import com.huella.modelo.Edificio;
import com.huella.modelo.Coche;
import com.huella.modelo.Bicicleta;
import com.huella.servicio.GestorArchivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AplicacionHuellaCarbono {

    private final List<HuellaDeCarbono> fuentes;
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

    public void calcularYMostrarHuellas() {
        fuentes.stream().map((fuente) -> {
            System.out.println(fuente.obtenerDescripcion());
            return fuente;
        }).map((fuente) -> {
            System.out.println("Huella de Carbono: " + fuente.calcularHuellaCarbono());
            return fuente;
        }).forEachOrdered((_item) -> {
            System.out.println("--------------------------------------------");
        });
    }

    public void guardarResultados(String ruta) {
        try {
            gestorArchivos.guardarHuellas(ruta, fuentes);
            System.out.println("Resultados guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar los resultados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        AplicacionHuellaCarbono app = new AplicacionHuellaCarbono();

        app.inicializarDatos();
        app.calcularYMostrarHuellas();

        String rutaArchivo = "resultados_huella_carbono.txt";
        app.guardarResultados(rutaArchivo);
    }
}
