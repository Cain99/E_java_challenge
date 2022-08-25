package negocio;

import java.time.LocalDate;

public class Tarjeta {
	private String marca,nro_tarjeta,cardholder_name,cardholder_surname;
	private int m,y; //Mes y año de vencimiento
	public Tarjeta(String marca,String nro_tarjeta,String cardholder_name,String cardholder_surname,int i,int j) {
		super();
		this.marca=marca;
		this.nro_tarjeta=nro_tarjeta;
		this.cardholder_name=cardholder_name;
		this.cardholder_surname=cardholder_surname;
		this.m=i;
		this.y=j;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNro_tarjeta() {
		return nro_tarjeta;
	}
	public void setNro_tarjeta(String nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}
	public String getCardholder_name() {
		return cardholder_name;
	}
	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}
	public String getCardholder_surname() {
		return cardholder_surname;
	}
	public void setCardholder_surname(String cardholder_surname) {
		this.cardholder_surname = cardholder_surname;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String getFecha_vencimiento() {
		return (""+this.m+"/"+this.y);
	}
	
	public double calcularTasaServicio(int monto) throws Exception {
		double tasa;
		if(marca=="VISA") {
			tasa=(y%100)/m;
		}else if(marca=="NARA") {
			tasa= m*0.5;
		}else if(marca=="AMEX") {
			tasa= m*0.1;
		}else {
			throw new Exception("Marca no registrada");
		}
		return (monto*tasa)/100;
	}
	public boolean expiro() {
		return (LocalDate.now().isAfter(LocalDate.of(y,m, 1)));
	}
	@Override
	public String toString() {
		return "Tarjeta [marca=" + marca + ", nro_tarjeta=" + nro_tarjeta + ", cardholder_name=" + cardholder_name
				+ ", cardholder_surname=" + cardholder_surname + ", Fecha de vencimiento=" + getFecha_vencimiento()
				+ "]";
	}
	public boolean equals(Tarjeta t) {
		return t.getNro_tarjeta()==nro_tarjeta;
	};
	
}
