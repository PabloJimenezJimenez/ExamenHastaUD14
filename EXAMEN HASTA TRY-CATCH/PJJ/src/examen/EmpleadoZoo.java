package examen;

public class EmpleadoZoo implements Cuidador{
	private int numEmpleado;
	private String nombre;
	private String apellido;
	private double salario;
	private Animales animalCuidado;
	public EmpleadoZoo(int numEmpleado, String nombre, String apellido, double salario) {
		this.numEmpleado = numEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.animalCuidado=new Animales("default", "default","default", 0);
	}
	
	
	@Override
	public void alimentar(int alimento) {
		System.out.println("Has alimentado al animal"+animalCuidado.getNombre());
		
	}
	public int getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getAnimalCuidado() {
		return animalCuidado.getNombre();
	}


	public void setAnimalCuidado(Animales animalCuidado) {
		this.animalCuidado = animalCuidado;
	}


	public void asignarAnimal(Animales animal) {
		this.animalCuidado=animal;
	}
	
}
