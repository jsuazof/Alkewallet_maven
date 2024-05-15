package alkewallet.vista;

public class Menu {

    public void dibujaMenu() {

        String menu = """
                **
                 1- Deposito                                
                 2- Retiro                                  
                 3- Saldo                                   
                 4- Clientes                                
                 5- Conversor de monedas                    
                 6- Salir                                   
                **""";
        System.out.println(menu);
    }
    public void dibujaMenuConversor() {

        String menuConversor = """
                **
                 1- Peso Chileno a Dolar                    
                 2- Peso Chileno a Euro                     
                 3- Salir                                   
                **""";
        System.out.println(menuConversor);
    }

}

