package alkewallet.model;

import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mockito;

public class ClienteTest {
    @Test
    public void testCrearCliente() {
        Scanner scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.next()).thenReturn("Jorge","Suazo","jorge@email.cl", "21779332-7");
        Cliente cliente = new Cliente();
        cliente.crearCliente(scannerMock);
    }
}
