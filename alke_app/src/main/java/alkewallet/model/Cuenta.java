package alkewallet.model;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import alkewallet.api.ApiMonedas;
import alkewallet.utils.LimpiarPantalla;

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
        System.out.printf(" %-10s : %-8s        %n", "Nombre", cliente.getNombre());
        System.out.printf(" %-10s : %-8s        %n", "N°Cuenta:", getCtaNumero());
        System.out.printf(" %-10s : %-8s        %n", "saldo:", consultaSaldo());
        System.out.printf("--------------------------------%n");
        System.out.println();

    }

    @SuppressWarnings ("resource");
    @Override public void retirar(Double monto){
        while(!validarRetiro(monto)){
            System.out.println("Por favor ingrese un monto válido");
            try{
                Double input = Double.parseDouble(new Scanner(System.in).next());
                monto = input;
            }catch(NumberFormatException e ){
            }
            LimpiarPantalla.limpiarConsola();
        }
        this.saldo -= monto;

		System.out.println();
		System.out.printf("--------------------------------%n");
		System.out.printf(" Retiro realizado con exito    %n");
		System.out.printf("--------------------------------%n");
		System.out.printf(" %-10s : %-8s        %n", "Nombre", cliente.getNombre());
		System.out.printf(" %-10s : %-8s        %n", "N°Cuenta:", getCtaNumero());
		System.out.printf(" %-10s : %-8s        %n", "saldo:", consultaSaldo());
		System.out.printf("--------------------------------%n");
		System.out.println();

	}

    @Override
    public double consultaSaldo() {
        return this.saldo;
    }

    public void ConvertirMoneda(Scanner entrada){
        if(this.saldo > 0){
            ApiMonedas monedas =new ApiMonedas();
            monedas.GetIndicadores();
            System.out.println("Ingrese la moneda a convertir (Dolar o Euro)");
            String tipoCambio = entrada.next();
            Double monto = null;
            entrada.nextLine();
            try{
                System.out.println("Ingrese Monto a convertir");
                String inputmonto = entrada.next();
                if(!isNumeric(inputmonto)){
                throw new Exception("Error: ingrese un monto válido");
                }
                monto = Double.parseDouble(inputmonto);
                if(monto > saldo){
                    throw new Exception("Error: saldo insuficiente");
                }else if (monto <= 0){
                    throw new Exception("Error: ingrese un monto válido");
                }    
            }catch(Exception e){
                System.out.println("Error:" + e.getMessage());
                return;
        }
        if(monedas.getMonedas().containsKey(tipoCambio)){
            Double valorDolar = 1 / monedas.getMonedas().get(tipoCambio).getValor().doubleValue();
            Double valorFinal = monto * valorDolar;
            System.out.println("El monto convertido es:"
             + monedas.getMonedas().get(tipoCambio).getSimbolo().toString() + " " + valorFinal
             + " "
             +monedas.getMonedas().get(tipoCambio).getPluralName().toString());
        }else{
            System.out.println("Error: moneda no encontrada");
            
        }
    }else{
            System.out.println("Sin saldo para convertir");
        }
    }
    public static boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean validarDeposito(Double cantidad) {
        if(cantidad <= 0){
            return false;
        } else {
            return true;
        }
    }
    public boolean validarRetiro(Double cantidad){
        if(cantidad <= 0){
            return false;
        }else if (this.saldo < cantidad){
            return false;
        }else{
            return true;
        }
    }


}

