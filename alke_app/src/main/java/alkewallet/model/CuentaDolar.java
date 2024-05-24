package alkewallet.model;

import alkewallet.servicio.ServicioConversorMoneda;

public class CuentaDolar extends ServicioConversorMoneda {

    private final double maxDeposito;
    private double depositoActual;

    public CuentaDolar() {
        super(Moneda.USD);
        this.maxDeposito = 100000;
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
        if (saldo > retiro * 1.02) {
            return;
        }
        saldo -= retiro * 1.02;

    }

    @Override
    public boolean verDepositar(double deposito) {
        return maxDeposito >= (depositoActual + deposito);
    }

    @Override
    public boolean verRetirar(double retiro) {
        return saldo >= retiro * 1.02;
    }

    @Override
    public double convertir(double monto) {

        return monto * 950;
    }

    @Override
    public double reConvertir(double monto) {

        return monto / 950;

    }

    @Override
    public String toString() {

        return String.format("**%15s%-10s%10s%12.2f  **\n", "Numero Cta:",
                Integer.toString(ctaNumero), "Saldo:", saldo) +
                String.format("**%15s%-10s%10s%12.2f  **\n", "Moneda:",
                        moneda, "Saldo:", this.convertir(saldo));
    }

}
