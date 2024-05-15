package alkewallet;

import java.util.LinkedList;
import java.util.List;

import alkewallet.model.Cliente;
import alkewallet.model.Cuenta;
import alkewallet.vista.Menu;

public class Main {
    public static void main(String[] args) {
      

        
        Menu menu = new Menu();
        menu.dibujaMenu();
        menu.dibujaMenuConversor();
    }

}