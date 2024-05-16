package alkewallet.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



public class ClienteTest {

    Cliente cliente;
    Cuenta cuentaCorriente;
    Cuenta cuentaRut;
    Cuenta cuentaDolar;
    Cuenta cuentaEuro;

    @BeforeEach
    public void instanciar(){
        cliente = new Cliente("Jorge", "Suazo", "18566678-1","555555");
        cuentaCorriente = new CuentaCorriente();
        cuentaRut = new CuentaRut();
        cuentaDolar = new CuentaDolar();
        cuentaEuro = new CuentaEuro();
        cliente.addCuenta(cuentaCorriente);
        cliente.addCuenta(cuentaRut);
        cliente.addCuenta(cuentaDolar);
        cliente.addCuenta(cuentaEuro);

        cuentaCorriente.depositar(11000);
        cuentaRut.depositar(21000);
        cuentaDolar.depositar(31000);
        cuentaEuro.depositar(41000);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0, 500000})
    @DisplayName("Prueba exitosa")
    void transferir(double monto){
        boolean resultado = cliente.transferir(0, 0, monto);
        System.out.println(monto + " " + resultado);
        assertTrue(resultado);
    }
    @ParameterizedTest
    @ValueSource(doubles = {500010, 3400000})
    @DisplayName("Prueba fracasada")
    void testTransferir2(double monto) {
        boolean resultado = cliente.transferir(0, 0 , monto);
        System.out.println(monto + " " + resultado);
        assertFalse(resultado);

    }
}
