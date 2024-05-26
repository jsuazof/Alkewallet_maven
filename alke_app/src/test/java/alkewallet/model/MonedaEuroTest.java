package alkewallet.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MonedaEuroTest {
    @Test
    public void testGetNombre() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0);
        assertEquals("MonedaEuro", euro.getNombre());
    }

    @Test
    public void testGetValor() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0);
        assertEquals(1.0, euro.getValor(), 0.001);
    }

    @Test
    public void testGetPluralName() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0);
        assertEquals("Euros", euro.getPluralName());
    }

    @Test
    public void testGetSimbol() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0);
        assertEquals("€", euro.getSimbolo());
    }

    @Test
    public void testSetNombre() {
        MonedaEuro monedaEuro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0 );
        monedaEuro.setNombre("MonedaEuro");
        assertEquals("MonedaEuro", monedaEuro.getNombre());
    }

    @Test
    public void testSetValor() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0 );
        euro.setValor(1.0);
        assertEquals(1.0, euro.getValor(), 0.001);
    }

    @Test
    public void testSetPluralName() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0 );
        euro.setPluralName("Euros");
        assertEquals("Euros", euro.getPluralName());
    }

    @Test
    public void testSetSimbol() {
        MonedaEuro euro = new MonedaEuro("MonedaEuro", "€", "Euros", 1.0 );
        euro.setSimbol("€");
        assertEquals("€", euro.getSimbolo());
    }
}
