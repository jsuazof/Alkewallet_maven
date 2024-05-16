package alkewallet.model;

public class CuentaRut extends Cuenta {

    private double maxDeposito;
    private double depositoActual;

    public CuentaRut() {
        super(Moneda.CLP);
        this.maxDeposito = 2000000;
        this.depositoActual = 0;
    }

    @Override
    public boolean depositar(double deposito) {
        if (maxDeposito < (depositoActual + deposito)) {
            return false;
        }
        saldo += deposito;
        depositoActual += deposito;
        return true;

    }

    @Override
    public boolean retirar(double retiro) {
        if (saldo < retiro) {
            return false;
        }
        saldo -= retiro;
        return true;
    }

    @Override
    public boolean verDepositar(double deposito) {
        if(maxDeposito < (depositoActual - deposito)){
            return false;
        }
        return true;
    }

    @Override
    public boolean verRetirar(double retiro) {
        if (saldo < retiro) {
            return false;
            
        }
        return true;
    }

}
