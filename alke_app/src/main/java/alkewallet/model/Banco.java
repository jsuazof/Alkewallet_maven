package alkewallet.model;

import java.util.ArrayList;
import java.util.List;

import alkewallet.vista.Menu;

public class Banco {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<Cliente>();

        Cliente cliente1 = new Cliente("Jorge", "Suazo", "15689777-2", "556677");
        Cliente cliente2 = new Cliente("Ruperto", "Mardones", "22536789-1", "777777");

        Cuenta cuentaCorriente = new CuentaCorriente();
        Cuenta cuentaRut = new CuentaRut();
        Cuenta cuentaDolar = new CuentaDolar();
        Cuenta cuentaEuro = new CuentaEuro();
        Cuenta cuentaCorriente2 = new CuentaCorriente();
        Cuenta cuentaRut2 = new CuentaRut();
        Cuenta cuentaDolar2 = new CuentaDolar();
        Cuenta cuentaEuro2 = new CuentaEuro();

        cliente1.addCuenta(cuentaCorriente);
        cliente1.addCuenta(cuentaRut);
        cliente1.addCuenta(cuentaDolar);
        cliente1.addCuenta(cuentaEuro);

        cliente2.addCuenta(cuentaCorriente2);
        cliente2.addCuenta(cuentaRut2);
        cliente2.addCuenta(cuentaDolar2);
        cliente2.addCuenta(cuentaEuro2);

        cuentaCorriente.depositar(200000);
        cuentaRut.depositar(69420);
        cuentaDolar.depositar(10000);
        cuentaEuro.depositar(5000);

        cuentaCorriente2.depositar(700000);
        cuentaRut2.depositar(109420);
        cuentaDolar2.depositar(20000);
        cuentaEuro2.depositar(10000);

        cliente1.transferir(0, 1, 100000);

        transferenciaCliente(cliente2, cliente1, 0, 0, 543320);
        cliente2.transferir(2, 0, 1000);

        Menu.printMenu(cliente1.getCuentas());
        System.out.println(cliente1);
        System.out.println(cliente2);

    }

    public static boolean transferenciaCliente(Cliente clienteOrigen, Cliente clienteDestino, int origen, int destino,
            double monto) {
        Cuenta cuentaOrigen = clienteOrigen.getCuentas().get(origen);
        Cuenta cuentaDestino = clienteDestino.getCuentas().get(destino);
        if (cuentaOrigen.getMoneda() != cuentaDestino.getMoneda()) {
            return false;
        }

        if (cuentaOrigen.verRetirar(monto) && cuentaDestino.verDepositar(monto)) {
            cuentaOrigen.retirar(monto);
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }

}
