/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USUARIO
 */
import com.huella.modelo.Coche;
import org.junit.Test;
import static org.junit.Assert.*;

public class CocheTest {

    @Test
    public void testCalcularHuellaCarbono() {

        Coche coche = new Coche("Coche Prueba", 1000, 2.0);

        double resultado = coche.calcularHuellaCarbono();

        assertEquals(2000.0, resultado, 0.001);
    }
}