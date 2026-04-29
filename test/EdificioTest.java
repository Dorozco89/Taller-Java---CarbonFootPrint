/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */ 
import com.huella.modelo.Edificio;
import org.junit.Test;
import static org.junit.Assert.*;

public class EdificioTest {

    @Test
    public void testCalcularHuellaCarbono() {

        Edificio edificio = new Edificio("Edificio Prueba", 1000, 0.5);

        double resultado = edificio.calcularHuellaCarbono();

        assertEquals(500.0, resultado, 0.001);
    }
}