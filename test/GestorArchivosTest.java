/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
import com.huella.modelo.*;
import com.huella.servicio.GestorArchivos;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivosTest {

    @Test
    public void testGuardarYLeerObjetos() throws IOException {

        List<HuellaDeCarbono> lista = new ArrayList<>();
        lista.add(new Edificio("Edificio Test", 1000, 0.5));
        lista.add(new Coche("Coche Test", 500, 2.0));
        lista.add(new Bicicleta("Bici Test", 2000));

        GestorArchivos gestor = new GestorArchivos();
        String ruta = "test_objetos.txt";

        gestor.guardarObjetos(ruta, lista);

        List<HuellaDeCarbono> listaLeida = gestor.leerObjetos(ruta);

        assertEquals(3, listaLeida.size());

        assertTrue(listaLeida.get(0) instanceof Edificio);
        assertTrue(listaLeida.get(1) instanceof Coche);
        assertTrue(listaLeida.get(2) instanceof Bicicleta);

        assertEquals(500.0, listaLeida.get(0).calcularHuellaCarbono(), 0.001);
        assertEquals(1000.0, listaLeida.get(1).calcularHuellaCarbono(), 0.001);
        assertEquals(0.0, listaLeida.get(2).calcularHuellaCarbono(), 0.001);
    }
}