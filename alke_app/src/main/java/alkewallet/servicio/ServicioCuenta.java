package alkewallet.servicio;

import alkewallet.model.Cuenta;

public class ServicioCuenta {

    public boolean depositar(Cuenta cuenta, double monto){
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        return true;
    }
    public boolean retirar(Cuenta cuenta, double monto){
        if(cuenta.getSaldo()<monto){
            return false;
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        return true;
    }

}
