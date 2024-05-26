package alkewallet.model;

public interface CuentaInterface {
    void retirar(Double cantidad);
    double consultaSaldo();
    int consultaSaldoRedondeado();
    void depositar(Double cantidad);
}

