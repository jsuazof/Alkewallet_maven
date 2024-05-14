package alkewallet.service;

import java.util.HashMap;
import java.util.Map;

import alkewallet.model.Cliente;

public class ServiceCliente {

    private Map<String, Cliente> clientes;

    public ServiceCliente(){
        this.clientes = new HashMap<String, Cliente>();
    }

    public String crearCliente(Cliente cliente){
        if(cliente == null){
            return "Creacion fallida, verifique cliente";
        }
        clientes.put(cliente.getRut(), cliente);
        return "Cliente creado";
    }

    public Map<String, Cliente>leerClientes(){
        return this.clientes;
    }

    public String actualizarCliente(Cliente cliente){
        if(cliente == null){
            return "Actualizacion fallida, verifique cliente";
        }
        clientes.put(cliente.getRut(), cliente);
        return "Cliente actualizado";
    }

    public String eliminarCliente(Cliente cliente){
        if(cliente == null){
            return "Eliminación fallida, verifique cliente";
        }
        clientes.remove(cliente.getRut());
        return "Cliente eliminado";
    }


}
