package alkewallet;

import java.util.LinkedList;
import java.util.List;

import alkewallet.model.Cliente;
import alkewallet.model.Cuenta;
import alkewallet.model.Menu;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Jorge", "Suazo", "15689777-2", "556677");
        Cliente cliente2 = new Cliente("Ruperto", "Mardones", "22536789-1", "777777");
        Cuenta cuenta1 = new Cuenta(123456);
        Cuenta cuenta2 = new Cuenta(654321);

        List<Cliente> clientes = new LinkedList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        cliente1.getCuentas().add(cuenta1);
        cliente1.getCuentas().add(cuenta2);

        
        Menu menu = new Menu();
        menu.dibujaMenu();
        menu.dibujaMenuConversor();
    }

}