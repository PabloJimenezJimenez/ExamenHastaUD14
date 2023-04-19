package examen;

public class Animales implements Comparable<Animales>{
	private String nombre;
	private String genero;
	private String especie;
	private int edad;
	public Animales(String nombre, String genero, String especie, int edad) {
		this.nombre = nombre;
		this.genero = genero;
		this.especie = especie;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", genero=" + genero + ", especie=" + especie + ", edad=" + edad ;
	}
	@Override
	public int compareTo(Animales o) {
		if(this.edad>o.edad) {
			return 1;
		}
		if(this.edad<o.edad) {
			return -1;
		}
		return 0;
	}
	
	
	
}
