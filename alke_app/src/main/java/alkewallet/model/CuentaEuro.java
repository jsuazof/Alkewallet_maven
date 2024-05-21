package alkewallet.model;

/**
 *
 * @author golden-dev
 */
public class CuentaEuro extends Cuenta implements Conversor {

    private final double maxDeposito;
    private double depositoActual;
    public CuentaEuro(){
        super(Moneda.EUR);
        this.maxDeposito = 100000;
        this.depositoActual = 0;
    }
    @Override
    public void depositar(double deposito) {
        if(maxDeposito < (depositoActual+deposito)){
            return;
        }
        saldo += deposito;
        depositoActual += deposito;
    }
    @Override
    public void retirar(double retiro) {
        if(saldo < retiro*1.03){
            return;
        }
        saldo -= retiro*1.03;
    }
    @Override
    public boolean verDepositar(double deposito) {
        return maxDeposito >= (depositoActual+deposito);
    }
    @Override
    public boolean verRetirar(double retiro) {
        return saldo >= retiro*1.03;
    }
    @Override
    public double convertir(double monto) {
        
        return monto * 1050;
    }
    @Override
    public double reConvertir(double monto) {
        
        return monto / 1050;
        
    }
    @Override
    public String toString() {

        return String.format("**%15s%-10s%10s%12.2f  **\n", "Numero Cta:", 
        Integer.toString(ctaNumero), "Saldo:", saldo)+
        String.format("**%15s%-10s%10s%12.2f  **\n", "Moneda:", 
                moneda, "Saldo:", this.convertir(saldo));
    }

    
}
