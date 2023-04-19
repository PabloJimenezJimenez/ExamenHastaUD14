package examen;

import java.util.ArrayList;
import java.util.Scanner;

public class Habitat {
	static Scanner sc=new Scanner(System.in);
	private String nombre;
	private ArrayList<Animales>animales;
	public Habitat(String nombre) {
		this.nombre = nombre;
		this.animales = new ArrayList<>();
	}
	public Habitat(String nombre, ArrayList<Animales>animales) {
		this.nombre = nombre;
		this.animales = animales;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void getAnimales() {
		for (Animales animal : animales) {
			System.out.println(animal.getNombre()+" "+animal.getGenero()
			+" "+animal.getEdad()+" "+animal.getEspecie());
		}
	}
	public void setAnimales(Animales animal) {
		animales.add(animal);
	}
	
	public void borrarAnimal(String nombre_animal) {
		for(int i=0;i<animales.size();i++) {
			if(animales.get(i).getNombre().equalsIgnoreCase(nombre_animal)) {
				animales.remove(i);break;
			}
		}
		System.out.println("Animal no encontrado en el habitat");
	}
	public String getNombreAnimales(String nombre) {
		for (Animales animal : animales) {
			if(animal.getNombre().equals(nombre)) {
				return this.nombre;
			}
		}
		return "";
	}
}
