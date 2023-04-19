package examen;

public class Aves extends Animales{
	private boolean sonRapaces;
	private int longPico;
	public Aves(String nombre, String genero, String especie, int edad, boolean sonRapaces, int longPico) {
		super(nombre, genero, especie, edad);
		this.sonRapaces = sonRapaces;
		this.longPico = longPico;
	}
	public boolean isSonRapaces() {
		return sonRapaces;
	}
	public void setSonRapaces(boolean sonRapaces) {
		this.sonRapaces = sonRapaces;
	}
	public int getLongPico() {
		return longPico;
	}
	public void setLongPico(int longPico) {
		this.longPico = longPico;
	}
	@Override
	public String toString() {
		return "Aves [sonRapaces=" + sonRapaces + ", longPico=" + longPico + " "+super.toString()+"]";
	}
	
}
