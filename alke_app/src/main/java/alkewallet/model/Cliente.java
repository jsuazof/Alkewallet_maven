package alkewallet.model;

import java.util.Scanner;
import java.util.UUID;

import alkewallet.utils.LimpiarPantalla;

public class Cliente {

    private UUID userId;
    private String nombre;
    private String apellido;
    private String rut;
    private String email;
    private Cuenta cuenta;

    public Cliente() {
        this.userId = UUID.randomUUID();
        cuenta = new Cuenta();
    }
    public Cliente(UUID userId, String nombre, String apellido, String rut, String email, Cuenta cuenta) {
        this.userId = userId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.email = email;
        this.cuenta = cuenta;
    }
    


    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public void crearCliente(Scanner entrada){
        System.out.println();
        System.out.println("Ingrese su Nombre:");
        String nombre = entrada.next();
        while(!validarString(nombre)){
            System.out.println("Por favor, ingrese un nombre válido");
            nombre = entrada.next();
        }
        setNombre(nombre);
        entrada.nextLine();

        System.out.println("Ingrese su Apellido");
        String apellido = entrada.next();
        while(!validarString(apellido)){
            System.out.println("Por favor, ingrese un apellido válido");
            apellido = entrada.next();
        }
        setApellido(apellido);
        entrada.nextLine();

        System.out.println("Ingrese su email");
        String email = entrada.next();
        while(!validarEmail(email)){
            System.out.println("Por favor, ingrese un email válido");
            email = entrada.next();
        }
        setEmail(email);

        System.out.println("Ingrese su rut");
        String rut = entrada.next();
        while(!validarRut(rut)){
            System.out.println("Por favor, ingrese un rut válido");
            rut = entrada.next();
        }
        setRut(rut);

        LimpiarPantalla.limpiarConsola();

        System.out.println();
		System.out.printf("********************************%n");
		System.out.printf("   Cliente creado con éxito!    %n");
		System.out.printf("********************************%n");
		System.out.printf(" %-10s : %-8s        %n", "Nombre", getNombre());
		System.out.printf(" %-10s : %-8s        %n", "Email", getEmail());
		System.out.printf(" %-10s : %-8s        %n", "Rut", getRut());
		System.out.printf(" %-10s : %-8s        %n", "N°Cuenta:", cuenta.getCtaNumero());
		System.out.printf("********************************%n");
		System.out.println();
        System.out.println("Presiona Enter para continuar...");
    }
    public boolean validarString(String string) {   
        return !string.isEmpty()&&string.matches("^[a-zA-Z]*$");
    }

    public boolean validarEmail(String email){
        String emailRegex = "^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+[\\w-]+$";
        return email.matches(emailRegex);
    }
    public boolean validarRut(String rut){
        boolean validacion = false;
        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s= 1;
        for(; rutAux !=0; rutAux /= 10){
            s= (s + rutAux % 10 * (9 - m++ % 6))%11;
        }
        if (dv == (char)(s != 0 ? s + 47 : 75)){
            validacion = true;
        }
        return validacion;
    }
   
}
