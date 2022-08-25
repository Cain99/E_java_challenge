package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Sistema {
	List<Tarjeta> lst_tarjeta=new ArrayList<Tarjeta>();
	
	public Sistema() {
		super();
	}
	
	public Tarjeta traerTarjeta(String nro_tarjeta) {
		Iterator<Tarjeta> tar = lst_tarjeta.iterator();
		Tarjeta resultado = null;
		while (tar.hasNext()) {
			Tarjeta tarjetaIterador = tar.next();
			if (tarjetaIterador.getNro_tarjeta() == nro_tarjeta) {
				resultado = tarjetaIterador;
				break; //AL ALLAR LA TARJETA BUSCADA, SE ROMPE EL BUCLE WHILE
			}
		}
		return resultado;
	}

	public boolean agregarTarjeta(String marca,String nro_tarjeta,String cardholder_name,String cardholder_surname,int i,int j) {
		return lst_tarjeta.add(new Tarjeta(marca,nro_tarjeta,cardholder_name,cardholder_surname,i,j));
	}
	
	public boolean operarTarjeta(String nro_tarjeta,int monto) throws Exception{
		Tarjeta t=traerTarjeta(nro_tarjeta);
		if(t==null) {
			throw new Exception("No existe la tarjeta");
		}
		//una operacion es valida si la persona que opera el mismo consume menos de 1000 pesos
		if(monto>1000) { 
			throw new Exception("Monto invalido");
		}
		//una tarjeta es valida si su fecha de vencimiento es mayor que el presente dia
		if(t.expiro()) {
			throw new Exception("Tarjeta vencida");
		}
		return true;
	}
	public boolean tarjetaValida(String nro_tarjeta) {
		Tarjeta t=traerTarjeta(nro_tarjeta);
		return !(t.expiro());
	}
	public boolean tarjetasIguales(String t1,String t2) {
		Tarjeta tar1=traerTarjeta(t1);
		Tarjeta tar2=traerTarjeta(t2);
		return tar1.equals(tar2);
	}
	public String imprimirTarjeta(String nro_tarjeta) {
		Tarjeta t= traerTarjeta(nro_tarjeta);
		return t.toString();
	}
	public void indicarTasa(int monto,String nro_tarjeta) {
		Tarjeta t=traerTarjeta(nro_tarjeta);
		try {
			System.out.println( "Monto: "+monto+ " Marca: "+t.getMarca()+ " Importe: "+t.calcularTasaServicio(monto));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
