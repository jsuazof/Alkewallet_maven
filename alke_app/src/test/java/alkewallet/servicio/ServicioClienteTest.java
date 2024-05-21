package alkewallet.servicio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import alkewallet.model.Cliente;
 public class ServicioClienteTest {

    private ServicioCliente servicioCliente ;
    private Cliente cliente;

    @BeforeEach
    public void setUp(){
        servicioCliente = new ServicioCliente();
        cliente = new Cliente("Jorge", "Suazo", "25213355-5","55555");
    }

    @Test
    void testActualizarCliente() {
        var resultado = servicioCliente.actualizarCliente(cliente);
        assertEquals(resultado, "Cliente Actualizado");

    }

    @Test
    void testCrearCliente() {
        var resultado = servicioCliente.crearCliente(cliente);
        assertEquals(resultado, "Cliente creado");

    }

    @Test
    void testCrearClienteFallido(){
        var resultado = servicioCliente.crearCliente(null);
        assertEquals(resultado, "Creación fallida");
    }
    @Test
    void testActualizarClienteFallido(){
        var resultado = servicioCliente.actualizarCliente(null);
        assertEquals(resultado, "Actulización fallida");
    }
}
