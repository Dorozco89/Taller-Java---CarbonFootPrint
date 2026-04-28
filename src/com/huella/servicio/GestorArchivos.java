/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
package com.huella.servicio;

import com.huella.modelo.HuellaDeCarbono;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class GestorArchivos {

    public void guardarHuellas(String ruta, List<HuellaDeCarbono> fuentes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {

            for (HuellaDeCarbono fuente : fuentes) {
                String linea = fuente.obtenerDescripcion()
                        + " | Huella de Carbono: " + fuente.calcularHuellaCarbono();

                writer.write(linea);
                writer.newLine();
            }
        }
    }

    public List<String> leerDatos(String ruta) throws IOException {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }

        return lineas;
    }
}
