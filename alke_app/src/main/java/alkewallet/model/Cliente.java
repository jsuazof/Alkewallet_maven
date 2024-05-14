package alkewallet.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    private String nombre;
    private String apellido;
    private String rut;
    private String password;
    List<Cuenta>cuentas;
    
    public Cliente(String nombre, String apellido, String rut, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.password = password;
        cuentas = new ArrayList<>();
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
        return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + ", password=" + password
                + ", cuentas=" + cuentas + "]";
    }

    

}
