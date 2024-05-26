package alkewallet.model;

public class MonedaEuro implements Moneda {
    String nombre;
    String simbolo;
    String pluralName;
    Double valor;

    public MonedaEuro(String nombre, String simbolo, String pluralName, double valorEuroRedondeado) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.pluralName = pluralName;
        this.valor = valorEuroRedondeado;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    @Override
    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }
    @Override
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    

}
