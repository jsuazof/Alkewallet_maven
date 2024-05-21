package alkewallet.model;

import java.util.Random;

public class Cuenta {
    protected int ctaNumero;
    protected double saldo;
    protected Moneda moneda;

    public Cuenta(Moneda moneda) {
        super();
        this.ctaNumero = new Random().nextInt(1000000) + 1000000;
        this.moneda = moneda;
        this.saldo = 0;
    }

   
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

    public void depositar(double monto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    boolean verRetirar(double monto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    boolean verDepositar(double monto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void retirar(double monto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double convertir(double monto) {
        return monto * 950;
    }

    
}
