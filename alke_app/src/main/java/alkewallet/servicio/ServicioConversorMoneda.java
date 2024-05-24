package alkewallet.servicio;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import alkewallet.model.Moneda;


public class ServicioConversorMoneda {

	public static void convertir() {
		Moneda peso = new Moneda("Chilean Peso", 1, "CLP");
		Moneda dolar = new Moneda("American Dollar", 0.001065, "USD");
		Moneda euro = new Moneda("Euro", 0.00098855, "EUR");
	
		
		List<Moneda> monedas = new LinkedList<>();
		monedas.add(peso);
		monedas.add(dolar);
		monedas.add(euro);
		
		

		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingresa moneda base");
			String base = sc.next();
			System.out.println("Ingresa monto");
			double monto = sc.nextDouble();
			System.out.println("Ingresa moneda destino");
			String destino = sc.next();
			
			Moneda monedaBase = null;
			Moneda monedaDestino = null;
			
			for(Moneda m : monedas) {
				if(m.getCodigo().equals(base)) {
					monedaBase = m;
				}
				if(destino.equals(m.getCodigo())) { 
					monedaDestino = m;
				}
			}
			
			if(monedaBase == null || monedaDestino == null) {
				throw new RuntimeException();
			}
		
			
			System.out.println(monedaBase);
			System.out.println(monedaDestino);
			System.out.printf("La conversion es: %.2f", 
					(monto * monedaDestino.getTasa() / monedaBase.getTasa()));
		}catch (InputMismatchException e) {
			System.err.println("Ingrese un monto válido");
			convertir();
		}catch (RuntimeException e) {
			System.err.println("Ingrese una moneda válida");
			convertir();
		}catch (Exception e) {
			System.out.println("Error desconocido");
		}
	}

	public Double convertir(Double montoConvertido) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'convertir'");
	}

}