package examen;

import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
	static Scanner sc=new Scanner(System.in);
	private ArrayList<Habitat> habitats;

	public Zoo() {
		this.habitats = new ArrayList<>();
	}
	public void agregarHabitat(String nombreHabitat) {
		habitats.add(new Habitat(nombreHabitat));
	}
	public void eliminarHabitat(String nombreHabitat) {
		int num=habitats.size();
		for(int i=0;i<habitats.size();i++) {
			if(habitats.get(i).getNombre().toLowerCase().equals(nombreHabitat.toLowerCase())) {
				habitats.remove(habitats.get(i));break;
			}
		}
		if(habitats.size()==num) {
			System.out.println("Habitat no encontrado");
		}
		
	}
	public void agregarAnimal(String nombreHabitat,Animales animal) {
		int cont=0;
		for(int i=0;i<habitats.size();i++) {
		 if (habitats.get(i).getNombre().equalsIgnoreCase(nombreHabitat)) {
			habitats.get(i).setAnimales(animal);
			break;
		 }else {
			 cont++;
		 }
		}
		if(cont==habitats.size()) {
			System.out.println("Habitat no encontrado");
		}
	}
	
	public void eliminarAnimal(String nombreHabitat) {
		for(int i=0;i<habitats.size();i++) {
		 if (habitats.get(i).getNombre().toLowerCase().equals(nombreHabitat.toLowerCase())) {
			System.out.println("Introduzca el nombre del animal");
			String nombreAnimal=sc.nextLine();
			habitats.get(i).borrarAnimal(nombreAnimal);break;
		 }
		}
		System.out.println("Habitat no encontrado");
	}
	
	public void mostrarNombreHabitat(Animales animal) {
		for(int i=0;i<habitats.size();i++) {
			System.out.println(habitats.get(i).getNombreAnimales(animal.getNombre()));
		}
		
	}
	public boolean comprobarHabitat(String nombre_Habitat) {
		for(int i=0;i<habitats.size();i++) {
			if (habitats.get(i).getNombre().toLowerCase().equals(nombre_Habitat.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}
