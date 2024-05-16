package alkewallet.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private String rut;
    private String password;
    List<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, String rut, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.password = password;
        cuentas = new ArrayList<Cuenta>();
    }
    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {

        String resultado = new String();
        for (int i = 0; i < cuentas.size(); i++) {
            resultado += cuentas.get(i);
        }
        return "*****************************************************\n"
                + String.format("**%15s%-10s%10s%-14s**\n", "Nombre:", nombre, "Apellido:", apellido)
                + String.format("**%15s%-10s%10s%-14s**\n", "Password:", password, "RUT:", rut)
                + "*****************************************************\n" + resultado
                + "*****************************************************";

    }

    public boolean transferir(int origen, int destino, double monto) {
        Cuenta cuentaOrigen = cuentas.get(origen);
        Cuenta cuentaDestino = cuentas.get(destino);
        Double montoConvertido = monto;

        cuentaOrigen.retirar(monto);
        System.out.println("Retirando: " + monto);
        if (cuentaOrigen.getMoneda() != Moneda.CLP) {
            montoConvertido = ((Conversor) cuentaOrigen).convertir(montoConvertido);
            System.out.println("El monto convertido es: " + montoConvertido);

        }
        if (cuentaDestino.getMoneda() != Moneda.CLP) {
            montoConvertido = ((Conversor) cuentaDestino).reConvertir(montoConvertido);
            cuentaDestino.depositar(montoConvertido);
            System.out.println("El monto convertido es: " + montoConvertido);
            return true;

        } else {
            cuentaDestino.depositar(montoConvertido);
            return true;
        }
    }
}
