package alkewallet.model;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mockito;

public class CuentaTest {
    
    @Test
    public void testConvertirMoneda() {
        // Mock del Scanner
        Scanner scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.next()).thenReturn("dolar", "500");

        // Inicialización de la cuenta y cliente
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge");
        cuenta.setCliente(cliente);
        cuenta.setSaldo(3500.0);
        
        // Llamada al método que se quiere probar
        cuenta.ConvertirMoneda(scannerMock);

        // Verificación del resultado esperado
        double expected = 3500.00; // Ajusta esto según la lógica de tu método ConvertirMoneda
        double actual = cuenta.consultaSaldo();
        double delta = 0.0001; // Ajusta el delta según la precisión requerida
        assertEquals(expected, actual, delta);
    }

    @Test
    public void testDepositar() {
        // Inicialización de la cuenta y cliente
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge");
        cuenta.setCliente(cliente);
        
        // Llamada al método que se quiere probar
        cuenta.depositar(1000.0);
        
        // Verificación del resultado esperado
        double expected = 1000.0;
        double actual = cuenta.consultaSaldo();
        double delta = 0.0001; // Ajusta el delta según la precisión requerida
        assertEquals(expected, actual, delta);
    }

    @Test
    public void testRetirar() {
        // Inicialización de la cuenta y cliente
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge");
        cuenta.setCliente(cliente);
        cuenta.setSaldo(3500.0);
        
        // Llamada al método que se quiere probar
        cuenta.retirar(1000.0);
        
        // Verificación del resultado esperado
        double expected = 2500.0; // Ajusta esto según la lógica de tu método retirar
        double actual = cuenta.consultaSaldo();
        double delta = 0.0001; // Ajusta el delta según la precisión requerida
        assertEquals(expected, actual, delta);
    }
}
