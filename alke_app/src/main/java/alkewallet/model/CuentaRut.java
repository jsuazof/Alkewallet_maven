package alkewallet.model;

public class CuentaRut extends Cuenta {

    private final double maxDeposito;
    private double depositoActual;

    public CuentaRut() {
        super(Moneda.CLP);
        this.maxDeposito = 2000000;
        this.depositoActual = 0;
    }

    @Override
    public void depositar(double deposito) {
        if (maxDeposito < (depositoActual + deposito)) {
            return;
        }
        saldo += deposito;
        depositoActual += deposito;

    }

    @Override
    public void retirar(double retiro) {
        if (saldo < retiro) {
            return;
        }
        saldo -= retiro;
    }

    @Override
    public boolean verDepositar(double deposito) {
        return maxDeposito >= (depositoActual - deposito);
    }

    @Override
    public boolean verRetirar(double retiro) {
        return saldo >= retiro;
    }

}
