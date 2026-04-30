/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
import com.huella.modelo.Bicicleta;
import org.junit.Test;
import static org.junit.Assert.*;

public class BicicletaTest {

    @Test
    public void testCalcularHuellaCarbono() {

        Bicicleta bicicleta = new Bicicleta("Bicicleta Prueba", 5000);

        double resultado = bicicleta.calcularHuellaCarbono();

        assertEquals(0.0, resultado, 0.001);
    }
}
