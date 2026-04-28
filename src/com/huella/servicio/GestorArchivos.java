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

import com.huella.modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

    public void guardarObjetos(String ruta, List<HuellaDeCarbono> fuentes) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {

            for (HuellaDeCarbono fuente : fuentes) {

                if (fuente instanceof Edificio) {
                    Edificio e = (Edificio) fuente;
                    writer.write("EDIFICIO;" + e.getNombre() + ";" 
                            + e.getConsumoEnergiaAnual() + ";" 
                            + e.getFactorEmision());
                } 
                else if (fuente instanceof Coche) {
                    Coche c = (Coche) fuente;
                    writer.write("COCHE;" + c.getNombre() + ";" 
                            + c.getConsumoCombustibleAnual() + ";" 
                            + c.getFactorEmision());
                } 
                else if (fuente instanceof Bicicleta) {
                    Bicicleta b = (Bicicleta) fuente;
                    writer.write("BICICLETA;" + b.getNombre() + ";" 
                            + b.getKilometrosAnuales());
                }

                writer.newLine();
            }
        }
    }

    public List<HuellaDeCarbono> leerObjetos(String ruta) throws IOException {
        List<HuellaDeCarbono> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] datos = linea.split(";");

                switch (datos[0]) {

                    case "EDIFICIO":
                        lista.add(new Edificio(
                                datos[1],
                                Double.parseDouble(datos[2]),
                                Double.parseDouble(datos[3])
                        ));
                        break;

                    case "COCHE":
                        lista.add(new Coche(
                                datos[1],
                                Double.parseDouble(datos[2]),
                                Double.parseDouble(datos[3])
                        ));
                        break;

                    case "BICICLETA":
                        lista.add(new Bicicleta(
                                datos[1],
                                Double.parseDouble(datos[2])
                        ));
                        break;
                }
            }
        }

        return lista;
    }
}