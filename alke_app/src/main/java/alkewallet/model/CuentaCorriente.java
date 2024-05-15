package alkewallet.model;

public class CuentaCorriente extends Cuenta{
    private int numRetiro;

    public CuentaCorriente() {
        super(Moneda.CLP);
        this.numRetiro = 5;
    }
    @Override
    public boolean depositar(double deposito) {
        saldo += deposito;
        return true;
    }
    @Override
    public boolean retirar(double retiro) {
        if (saldo >= retiro && numRetiro > 0) {
            saldo -= retiro;
            numRetiro--;
            return true;
        }
        return false;
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
        if(saldo >= retiro && numRetiro > 0){
            return true;
        }
        return false;
    }
    
}
