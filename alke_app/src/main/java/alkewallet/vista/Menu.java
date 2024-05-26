package alkewallet.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import alkewallet.model.Cliente;
import alkewallet.utils.LimpiarPantalla;

public class Menu {
	Cliente cliente;

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Menu menu = new Menu();
		menu = menu.mainMenu(menu, entrada);
		entrada.close();
		System.out.println("Cerrando Alkewallet...");
	}

	private Menu mainMenu(Menu menu, Scanner entrada) {
		LimpiarPantalla.limpiarConsola();
		int selection = 0;
		do {
			System.out.println("Alkewallet");
			System.out.println("(1) Crear Cliente");
			System.out.println("(2) Ver Saldo");
			System.out.println("(3) Depositar o girar");
			System.out.println("(4) Convertir Moneda");
			System.out.println("(5) Salir");
			System.out.println("Selecione una opción: ");

			try {
				selection = entrada.nextInt();

			} catch (InputMismatchException e) {
				entrada.next().charAt(0);
			}
			switch (selection) {
				case 1:
					this.cliente = new Cliente();
					cliente.crearCliente(entrada);
					cliente.getCuenta().setCliente(cliente);
					break;
				case 2:
					if (this.cliente != null) {
						System.out.println("Su saldo es : $" + " " + cliente.getCuenta().consultaSaldo());
					} else {
						System.out.println("Debe crear un cliente");
					}
					break;
				case 3:
					return menu.submenu1(menu, entrada);
				case 4:
					if (this.cliente != null) {
						cliente.getCuenta().ConvertirMoneda(entrada);
					} else {
						System.out.println("Debe crear un cliente");
					}
					break;
				case 5:
					return menu;
				default:
					System.out.println("Ingrese una opción válida");
			}
			System.out.println("Presiona \"c\" y luego (enter) para continuar");
			entrada.next().charAt(0);
			LimpiarPantalla.limpiarConsola();

		} while (selection != 5);
		return menu;
	}

	private Menu submenu1(Menu menu, Scanner entrada) {
		LimpiarPantalla.limpiarConsola();
		int selection = 0;

		do {
			System.out.println("Bienvenido al submenu");
			System.out.println("(1) Depositar");
			System.out.println("(2) Retirar");
			System.out.println("(5) Regresar");
			System.out.println("Selecione una opción: ");

			try {
				selection = entrada.nextInt();
			} catch (InputMismatchException e) {
				entrada.next().charAt(0);
			}
			switch (selection) {
				case 1:
					if (this.cliente != null) {
						System.out.println("Ingrese un monto a depositar");
						String input = entrada.next();
						try {
							Double monto = Double.parseDouble(input);
							cliente.getCuenta().depositar(monto);
						} catch (NumberFormatException e) {
							System.out.println("Ingrese un monto válido");
						}
					} else {
						System.out.println("Debe crear un cliente");
					}
					break;
				case 2:
					if (this.cliente != null) {
						Double saldo = cliente.getCuenta().consultaSaldo();
						if (saldo > 0) {
							System.out.println("ingrese un monto a Retirar");
							String input = entrada.next();
							try {
								Double monto = Double.parseDouble(input);
								cliente.getCuenta().retirar(monto);
							} catch (NumberFormatException e) {
								System.out.println("Ingrese un monto válido");
							}
						} else {
							System.out.println("No tiene saldo para retirar");
						}
					} else {
						System.out.println("Debe crear un cliente");
					}
					break;
				case 5:
					return menu.mainMenu(menu, entrada);
				default:
					System.out.println("Ingrese una opción válida");
			}
			System.out.println("Presiona \"c\" y luego (enter) para continuar");
			entrada.next().charAt(0);
			LimpiarPantalla.limpiarConsola();
		} while (selection != 5);
		return menu;
	}

}
