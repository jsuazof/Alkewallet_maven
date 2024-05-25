package alkewallet.model;

public class MonedaEuro implements Moneda {
    String nombre;
    String simbol;
    String pluralName;
    Double valor;

    public MonedaEuro(String nombre, String simbol, String pluralName, Double valor) {
        this.nombre = nombre;
        this.simbol = simbol;
        this.pluralName = pluralName;
        this.valor = valor;
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
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
