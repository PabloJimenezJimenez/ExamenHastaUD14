package examen;

public class Reptil extends Animales{
	private String colorEscama;

	public Reptil(String nombre, String genero, String especie, int edad,String colorEscama) {
		super(nombre, genero, especie, edad);
		this.colorEscama=colorEscama;
	}

	public String getColorEscama() {
		return colorEscama;
	}

	public void setColorEscama(String colorEscama) {
		this.colorEscama = colorEscama;
	}

	@Override
	public String toString() {
		return "Reptil [colorEscama=" + colorEscama + " "+super.toString()+"]";
	}
	
}
