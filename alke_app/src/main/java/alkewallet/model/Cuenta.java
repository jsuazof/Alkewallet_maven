package alkewallet.model;

import java.util.Random;

public abstract class Cuenta {
    protected int ctaNumero;
    protected double saldo;
    protected Moneda moneda;

    public Cuenta(Moneda moneda) {
        super();
        this.ctaNumero = new Random().nextInt(1000000) + 1000000;
        this.moneda = moneda;
        this.saldo = 0;
    }

    public abstract boolean depositar(double deposito);

    public abstract boolean retirar(double retiro);

    public abstract boolean verDepositar(double deposito);

    public abstract boolean verRetirar(double retiro);

    @Override
    public String toString() {
        
        return String.format("**%15s%-10s%10s%12.2f  **\n", "Numero Cta:",
                Integer.toString(ctaNumero), "Saldo:", saldo) +
                String.format("**%15s%-10s%10s%12s  **\n", "Moneda:",
                        moneda, "", "");
        
    }

    public int getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(int ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    
}
