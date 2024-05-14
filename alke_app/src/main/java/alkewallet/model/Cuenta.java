package alkewallet.model;

public class Cuenta {
    private int ctaNumero;
    private double saldo;
    public Cuenta(int ctaNumero) {
        this.ctaNumero = ctaNumero;
        this.saldo = 0;
    }
    @Override
    public String toString() {
        return "Cuenta [ctaNumero=" + ctaNumero + ", saldo=" + saldo + "]";
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

    

}
