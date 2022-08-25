package test;
import negocio.Sistema;
public class Main {

	public static void main(String[] args) {
		Sistema s=new Sistema();
		String tarjeta1="123456789";
		String tarjeta2="321123321";
		String tarjeta3="123321123";
		
		// creo 3 objetos
		s.agregarTarjeta("VISA",tarjeta1, "Brian Emanuel", "Muñoz",7,2026);
		s.agregarTarjeta("NARA",tarjeta2, "Maria", "Perez",2,2023);
		s.agregarTarjeta("AMEX",tarjeta3, "Nicolaz", "Gomez",2,2021);
		
		//PIDO LA INFORMACION DE LAS TARJETAS
		System.out.println("\n [INFORMACION DE TARJETAS]");
		System.out.println(s.imprimirTarjeta(tarjeta1));
		System.out.println(s.imprimirTarjeta(tarjeta2));
		System.out.println(s.imprimirTarjeta(tarjeta3));
		
		//Indico si las siguientes operaciones son validas
		System.out.println("\n [VALIDACION DE OPERACIONES]");
		try {
			System.out.println("Operacion 1:"+s.operarTarjeta(tarjeta1, 259));
		} catch (Exception e) {
			System.out.println("Operacion 1:"+e.getMessage());
		}
		
		
		try {
			System.out.println("Operacion 2:"+s.operarTarjeta(tarjeta2, 1250));
		} catch (Exception e) {
			System.out.println("Operacion 2:"+e.getMessage());
		}
		
		
		try {
			System.out.println("Operacion 3:"+s.operarTarjeta(tarjeta3, 750));
		} catch (Exception e) {
			System.out.println("Operacion 3:"+e.getMessage());
		}
		
		//Indico si las tarjetas son validas para operar
		System.out.println("\n [VALIDACION DE TARJETAS]");
		System.out.println("Tarjeta 1 es valida:"+s.tarjetaValida(tarjeta1));		
		System.out.println("Tarjeta 2 es valida:"+s.tarjetaValida(tarjeta2));	
		System.out.println("Tarjeta 3 es valida:"+s.tarjetaValida(tarjeta3));	
		
		//Indico si dos tarjetas son iguales
		System.out.println("\n [COMPARACION DE TARJETA]");
		System.out.println("La tarjeta 1 y 2 son iguales? "+s.tarjetasIguales(tarjeta1, tarjeta2));
		
		//tasa de una operacion indicando tasa e informe
		System.out.println("\n [TASA DE OPERACION]");
		s.indicarTasa(500, tarjeta1);
		s.indicarTasa(500, tarjeta2);
		s.indicarTasa(500, tarjeta3);
		
		
		
		
		
	}

}
