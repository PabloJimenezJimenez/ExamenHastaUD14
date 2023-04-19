package examen;



@SuppressWarnings("serial")
public class CrearExcepciones extends Exception{
	
	public CrearExcepciones() {
	
	}
	
	public CrearExcepciones(String msg) {
		super(msg);
	}
}
