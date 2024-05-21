package alkewallet.servicio;

import java.util.HashMap;
import java.util.Map;

import alkewallet.model.Cliente;

public class ServicioCliente {

    private final Map<String, Cliente>clientes;

    public ServicioCliente(){
        clientes = new HashMap<String, Cliente>();
    }

    public String crearCliente(Cliente cliente){
        if(cliente == null){
            return "Creación fallida";
        }
        clientes.put(cliente.getRut(), cliente);
        return "Cliente creado";
    }

    public String actualizarCliente(Cliente cliente){
        if(cliente == null){
            return "Actualización fallida";
        }
        clientes.put(cliente.getRut(), cliente);
        return "Cliente Actualizado";
    }
}
