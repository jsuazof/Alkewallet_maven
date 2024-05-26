package alkewallet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MonedaDolarTest {

    @Test
    public void testGetNombre() {
        MonedaDolar monedaDolar = new MonedaDolar("MonedaDolar", "$", "Dolares", (int) 1.0);
        assertEquals("MonedaDolar", monedaDolar.getNombre());
    }

    @Test
    public void testGetValor() {
        MonedaDolar monedaDolar = new MonedaDolar("MonedaDolar", "$", "Dolares", (int) 1.0);
        assertEquals(1.0, monedaDolar.getValor(), 0.001);
    }

    @Test
    public void testGetPluralName() {
    	MonedaDolar monedaDolar = new MonedaDolar("MonedaDolar", "$", "Dolares", (int) 1.0);
        assertEquals("Dolares", monedaDolar.getPluralName());
    }

    @Test
    public void testGetSimbol() {
    	MonedaDolar monedaDolar = new MonedaDolar("MonedaDolar", "$", "Dolares", (int) 1.0);
        assertEquals("$", monedaDolar.getSimbolo());
    }

    @Test
    public void testSetNombre() {
        MonedaDolar monedaDolar = new MonedaDolar("Dolar", "$", "Dolares", (int) 1.0);
        monedaDolar.setNombre("MonedaDolar");
        assertEquals("MonedaDolar", monedaDolar.getNombre());
    }

    @Test
    public void testSetValor() {
    	MonedaDolar monedaDolar = new MonedaDolar("Dolar", "$", "Dolares", (int) 1.0);
        monedaDolar.setValor(1.0);
        assertEquals(1.0, monedaDolar.getValor(), 0.001);
    }

    @Test
    public void testSetPluralName() {
    	MonedaDolar monedaDolar = new MonedaDolar("Dolar", "$", "Dolares", (int) 1.0);
        monedaDolar.setPluralName("Dolares");
        assertEquals("Dolares", monedaDolar.getPluralName());
    }

    @Test
    public void testSetSimbol() {
    	MonedaDolar monedaDolar = new MonedaDolar("Dolar", "$", "Dolares", (int) 1.0);
        monedaDolar.setSimbolo("$");
        assertEquals("$", monedaDolar.getSimbolo());
    }
}
