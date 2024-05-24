package alkewallet.model;

public interface CuentaInterface {
    public void retirar(Double cantidad);
    public double consultaSaldo();
    public void depositar(Double cantidad);

}
