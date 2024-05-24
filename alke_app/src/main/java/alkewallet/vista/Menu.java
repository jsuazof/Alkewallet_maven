package alkewallet.vista;

import java.util.List;
import java.util.Scanner;

import alkewallet.model.Cliente;
import alkewallet.model.Cuenta;
import alkewallet.utils.LimpiarPantalla;

public class Menu {
	Cliente cliente;

	public static void main (String[] args){
		Scanner entrada = new Scanner(System.in);
		Menu menu = new Menu();
		menu = menu.mainMenu(menu, entrada);
		entrada.close();
		System.out.println("Cerrando Alkewallet...");
	}

	private Menu mainMenu(Menu menu, Scanner entrada){
		LimpiarPantalla.limpiarConsola();
		int selection = 0;
		do{
			System.out.println("Alkewallet");
			
		}
	}

}

