package alkewallet.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

import alkewallet.model.Cuenta;
import alkewallet.model.Moneda;


public class ServicioCuentaTest {

    ServicioCuenta servicioCuenta = new ServicioCuenta();
    Cuenta cuenta = new Cuenta(Moneda.CLP);
    @Test
    public void testDepositar() {
        double inicial = cuenta.getSaldo();
        double monto = 1000000;
        boolean exito = servicioCuenta.depositar(cuenta, 1000);
        double termino = cuenta.getSaldo();
        assertTrue(exito);

    }

    @Test
    public void testRetirar() {
        double monto = 2222222;
        servicioCuenta.depositar(cuenta, monto);
        double inicial = cuenta.getSaldo();
        var retiro = 2222;
        servicioCuenta.retirar(cuenta,2222);
        var termino = cuenta.getSaldo();
        assertEquals(inicial, termino, 2222);

    }
    @Test 
	public void testRetiroFallido() {
		double monto = 500000;
		servicioCuenta.depositar(cuenta, monto);
		double inicial = cuenta.getSaldo();
		var retiro = 1000000;
		boolean exito = servicioCuenta.retirar(cuenta, retiro);
		var termino = cuenta.getSaldo();
		assertFalse(exito);
	}

}
