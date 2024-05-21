package alkewallet.servicio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import alkewallet.model.Cliente;
public class ServicioClienteTest {

    ServicioCliente servicioCliente = new ServicioCliente() ;
    Cliente cliente = new Cliente("Jorge", "Suazo", "25213355-5","55555");

    

    @Test
    public void testActualizarCliente() {
        var resultado = servicioCliente.actualizarCliente(cliente);
        assertEquals(resultado, "Cliente Actualizado");

    }

    @Test
    public void testCrearCliente() {
        var resultado = servicioCliente.crearCliente(cliente);
        assertEquals(resultado, "Cliente creado");

    }

    @Test
    public void testCrearClienteFallido(){
        var resultado = servicioCliente.crearCliente(null);
        assertEquals(resultado, "Creación fallida");
    }
    @Test
    public void testActualizarClienteFallido(){
        var resultado = servicioCliente.actualizarCliente(null);
        assertEquals(resultado, "Actualización fallida");
    }
}
