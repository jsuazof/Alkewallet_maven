package alkewallet.model;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cuenta implements CuentaInterface {
    private String ctaNumero;
    private double saldo = 0;
    private Cliente cliente;

    public Cuenta() {
        this.ctaNumero = "CL"
                + new Random().ints(10, 0, 10).mapToObj(Integer::toString).collect(Collectors.joining());
    }

    public Cuenta(int ctaNumero, double saldo, Cliente cliente) {

        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(String ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @SuppressWarnings("resource")
    @Override
    public void depositar(Double monto) {
        while (!validarDeposito(monto)) {
            System.out.println("Ingrese un monto valido");
            try {
                Double input = Double.parseDouble(new Scanner(System.in).next());
                monto = input;
            } catch (NumberFormatException e) {
            }
            LimpiarPantalla.limpiarConsola();
        }
        this.saldo += monto;
        System.out.println();
        System.out.printf("--------------------------------%n");
        System.out.printf(" Deposito realizado con exito    %n");
        System.out.printf("--------------------------------%n");
        System.out.printf(" %-10s : %-8s        %n", "Nombre", usuario.getNombre());
        System.out.printf(" %-10s : %-8s        %n", "N°Cuenta:", getNumeroCuenta());
        System.out.printf(" %-10s : %-8s        %n", "saldo:", consultaSaldo());
        System.out.printf("--------------------------------%n");
        System.out.println();

    }

    @SuppressWarnings ("resource");
    @Overridepublic void retirar(Double monto){
        while(!validarRetiro(monto)){
            System.out.println("Por favor ingrese un monto válido");
            try{
                Double input = Double.parseDouble(new Scanner(System.in).next());
                monto = input;
            }catch(NumberFormatException e ){
            }
            LimpiarPantalla.limpiarConsola();
        }

    }
}
