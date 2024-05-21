package alkewallet.model;

public class CuentaCorriente extends Cuenta{
    private int numRetiro;

    public CuentaCorriente() {
        super(Moneda.CLP);
        this.numRetiro = 5;
    }
    @Override
    public void depositar(double deposito) {
        saldo += deposito;
    }
    @Override
    public void retirar(double retiro) {
        if (saldo >= retiro && numRetiro > 0) {
            saldo -= retiro;
            numRetiro--;
        }
    }
    public void resetRetiro(){
        numRetiro = 5;
    }
    @Override
    public boolean verDepositar(double deposito) {
        
        return true;
    }
    @Override
    public boolean verRetirar(double retiro) {
        return saldo >= retiro && numRetiro > 0;
    }

    
    
}
