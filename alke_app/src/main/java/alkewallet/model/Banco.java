package alkewallet.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Banco {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente("Jorge", "Suazo", "15689777-2", "556677");
        Cliente cliente2 = new Cliente("Ruperto", "Mardones", "22536789-1", "777777");
        
        

        
        clientes.add(cliente1);
        clientes.add(cliente2);

        cliente1.getCuentas().add(cuenta1);
        cliente1.getCuentas().add(cuenta2);
    }

}
