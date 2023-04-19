package examen;

import java.util.Scanner;

public class Mamifero extends Animales{
	static Scanner sc=new Scanner(System.in);
	private TipoDesp tipoDesp;
	public Mamifero(String nombre, String genero, String especie, int edad) {
		super(nombre, genero, especie, edad);
	}
	public TipoDesp getTipoDesp() {
		return tipoDesp;
	}
	public void setTipoDesp() {
		System.out.println("Tipos de desplazamiento [INTRODUZCA EL NUMERO]");
		System.out.println("1. Por tierra");
		System.out.println("2. Por mar");
		System.out.println("3. Por aire");
		int opc=0;
		while(opc !=1 && opc !=2 && opc!=3){
			opc=sc.nextInt();
		}
		if(opc==1) {
			this.tipoDesp=TipoDesp.TIERRA;
		}else if(opc==2) {
			this.tipoDesp=TipoDesp.MAR;
		}else {
			this.tipoDesp=TipoDesp.AIRE;
		}	
	}
	@Override
	public String toString() {
		return "Mamifero [tipoDesp=" + tipoDesp + " "+super.toString()+"]";
	}
	

	
}
