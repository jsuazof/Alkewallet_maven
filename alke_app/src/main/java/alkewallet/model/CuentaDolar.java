package alkewallet.model;

public class CuentaDolar extends Cuenta implements Conversor {

    private double maxDeposito;
    private double depositoActual;

    public CuentaDolar(){
        super(Moneda.USD);
        this.maxDeposito = 100000;
        this.depositoActual = 0;
    }

    @Override
    public boolean depositar(double deposito) {
        if(maxDeposito < (depositoActual+deposito)) {
            return false;
        }
        saldo += deposito;
        depositoActual += deposito;
        return true;
    }

    @Override
    public boolean retirar(double retiro) {
        if(saldo > retiro*1.02){
            return false;
        }
        saldo -= retiro*1.02;
        return false;
    }

    @Override
    public boolean verDepositar(double deposito) {
        if(maxDeposito < (depositoActual+deposito)) { 
            return false;
        }
        return true;
    }

    @Override
    public boolean verRetirar(double retiro) {
        if(saldo < retiro*1.02){
            return false;
        }
        return true;
    }

    @Override
    public double convertir(double monto) {
        
        return monto * 950;
    }

    @Override
    public double reConvertir(double monto) {
        // TODO Auto-generated method stub
        return 0;
    }

}
