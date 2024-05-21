package alkewallet.vista;

import java.util.List;
import java.util.Scanner;

import alkewallet.model.Cuenta;

public class Menu {

    	static String bienvenida = """
			*****************************************************
			**          Bienvenido al AlkeWallet               **
			*****************************************************""";

	static String menu = """
			*****************************************************
			** 1- Depositar                                    **
			** 2- Retirar                                      **
			** 0- Salir                                        **
			*****************************************************""";
	
	public static void printMenu(List<Cuenta> cuentas) {
		System.out.println(bienvenida);
		System.out.println(menu);
		execMenu(cuentas);
	}
	
	public static void execMenu(List<Cuenta> cuentas) {
		
		Scanner sc = new Scanner(System.in);
		int comando = sc.nextInt();
		
		switch(comando) {
		case 1 -> {
                    System.out.println("Ingrese cuenta origen");
                    int origen = sc.nextInt();
                    System.out.println("Ingrese el monto");
                    double monto = sc.nextDouble();
                    cuentas.get(origen).depositar(monto);
                    printMenu(cuentas);
                    }
		case 2 -> {
                    System.out.println("Ingresa cuenta a retirar");
					int destino = sc.nextInt();
					System.out.println("Ingrese el monto");
                    double monto = sc.nextDouble();
                    cuentas.get(destino).retirar(monto);
                    printMenu(cuentas);
                    }
		case 0 -> {
                    sc.close();
                    System.out.println("Has seleccionado salir");
                    }
		}
		
	}

}

