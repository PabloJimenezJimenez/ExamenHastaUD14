package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainZoo {
	static Scanner sc = new Scanner(System.in);
	static Zoo zoo = new Zoo();

	public static void main(String[] args) {
		ArrayList<Animales> animales = new ArrayList<>();
		ArrayList<EmpleadoZoo> empleados = new ArrayList<>();
		int opc = 0;
		boolean flag;
		while (opc != 8) {
			do {
				try {
					flag = false;
					menu();
					opc = sc.nextInt();
					condicional(opc, animales, empleados);
				} catch (InputMismatchException e) {
					flag = true;
					sc.nextLine();
					System.out.println("Introduce un int");
				}
			} while (flag);
		}

	}

	public static void menu() {
		System.out.println("***************MENU ZOO*********************");
		System.out.println("1. Agregar y eliminar animales del zoológico");
		System.out.println("2. Agregar y eliminar hábitats del zoológico");
		System.out.println("3. Agregar y eliminar cuidadores del zoológico");
		System.out.println("4. Asignar animales a hábitats específicos");
		System.out.println("5. Asignar cuidadores a animales específicos");
		System.out.println("6. Mostrar información detallada de cada animal, hábitat y cuidador");
		System.out.println("7. Mostrar los animales del zoo ordenados por edad");
		System.out.println("8. Salir");
	}

	public static void condicional(int opc, ArrayList<Animales> animales, ArrayList<EmpleadoZoo> empleados) {
		try {
			switch (opc) {
			case 1: {
				System.out.println("1. Agregar animal");
				System.out.println("2. Eliminar animal");
				int opc2 = sc.nextInt();
				while (opc2 != 1 && opc2 != 2) {
					System.out.println("Introduce 1 o 2");
					opc2 = sc.nextInt();
				}
				if (opc2 == 1) {
					try {
						crearAnimal(animales);
					} catch (CrearExcepciones e) {
						System.out.println(e.getMessage());
					}
				} else {
					eliminarAnimal(animales);
				}

				break;
			}
			case 2: {
				System.out.println("1. Agregar habitat");
				System.out.println("2. Eliminar habitat");
				int opc2 = 0;
				while (opc2 != 1 && opc2 != 2) {
					opc2 = sc.nextInt();
				}
				if (opc2 == 1) {
					try {
						anadirHabitat();
					} catch (CrearExcepciones e) {
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Introduzca el habitat a eliminar");
					sc.nextLine();
					String nombre_habitat = sc.nextLine();
					zoo.eliminarHabitat(nombre_habitat);
				}

				break;
			}
			case 3: {
				System.out.println("1. Agregar empleado");
				System.out.println("2. Eliminar empleado");
				int opc2 = 0;
				while (opc2 != 1 && opc2 != 2) {
					opc2 = sc.nextInt();
				}
				if (opc2 == 1) {
					try {
						crearEmpleado(empleados);
					} catch (CrearExcepciones e) {
						System.out.println(e.getMessage());
					}
				} else {
					eliminarEmpleado(empleados);
				}

				break;
			}
			case 4: {
				System.out.println("Nombre del animal a añadir");
				sc.nextLine();
				String nombreAnimal = sc.nextLine();
				Animales animal = comprobarAnimal(nombreAnimal, animales);
				System.out.println("Introduce el nombre del habitat");
				String nombreHabitat = sc.nextLine();
				zoo.agregarAnimal(nombreHabitat, animal);
				break;

			}
			case 5: {
				try {
					System.out.println("Nombre del animal a añadir");
					sc.nextLine();
					String nombreAnimal = sc.nextLine();
					Animales animal = comprobarAnimal(nombreAnimal, animales);
					System.out.println(animal.getNombre());
					System.out.println("Introduce el nombre del cuidador");
					String nombreCuidador = sc.nextLine();
					System.out.println(empleados.size());
					AnadirAnimalaEmpleado(nombreCuidador, empleados, animal);
				} catch (CrearExcepciones e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 6: {
				for (int i = 0; i < animales.size(); i++) {
					if (animales.get(i) instanceof Mamifero) {
						System.out.println(animales.get(i).toString());
						zoo.mostrarNombreHabitat(animales.get(i));
						nombreEmpleado(animales.get(i), empleados);
					}
					if (animales.get(i) instanceof Reptil) {
						System.out.println(animales.get(i).toString());
						zoo.mostrarNombreHabitat(animales.get(i));
						nombreEmpleado(animales.get(i), empleados);
					}
					if (animales.get(i) instanceof Aves) {
						System.out.println(animales.get(i).toString());
						zoo.mostrarNombreHabitat(animales.get(i));
						nombreEmpleado(animales.get(i), empleados);
					}
				}
				break;
			}
			case 7: {
				Collections.sort(animales);
				for (int i = 0; i < animales.size(); i++) {
					if (animales.get(i) instanceof Mamifero) {
						System.out.println(animales.get(i).toString());
						zoo.mostrarNombreHabitat(animales.get(i));
						nombreEmpleado(animales.get(i), empleados);
					}
					if (animales.get(i) instanceof Reptil) {
						System.out.println(animales.get(i).toString());
						zoo.mostrarNombreHabitat(animales.get(i));
						nombreEmpleado(animales.get(i), empleados);
					}
					if (animales.get(i) instanceof Aves) {
						System.out.println(animales.get(i).toString());
						zoo.mostrarNombreHabitat(animales.get(i));
						nombreEmpleado(animales.get(i), empleados);
					}
				}
				break;
			}
			}
		} catch (NullPointerException e) {
			System.out.println("Elemento no encontrado");
		}
	}

	private static void anadirHabitat() throws CrearExcepciones {
		System.out.println("Introduzca el nombre del habitat");
		sc.nextLine();
		String habitat = sc.nextLine();
		if (zoo.comprobarHabitat(habitat)) {
			CrearExcepciones e = new CrearExcepciones("HabitatExistenteException");
			throw e;
		}
		zoo.agregarHabitat(habitat);
	}

	private static void crearAnimal(ArrayList<Animales> animales) throws CrearExcepciones {
		System.out.println("Introduzca el nombre");
		sc.nextLine();
		String nombreAnimal = sc.nextLine();
		for (int i = 0; i < animales.size(); i++) {
			if (animales.get(i).getNombre().equalsIgnoreCase(nombreAnimal)) {
				CrearExcepciones e = new CrearExcepciones("AnimalExistenteException");
				throw e;
			}
		}
		System.out.println("Introduzca el genero");
		String genero = sc.nextLine();
		System.out.println("Introduzca el especie");
		String especie = sc.nextLine();
		System.out.println("Introduzca la edad");
		int edad = sc.nextInt();
		System.out.println("Introduzca la variedad del animal:");
		System.out.println("Mamifero");
		System.out.println("Ave");
		System.out.println("Reptil");
		String variedad = sc.nextLine();
		while ((!variedad.equalsIgnoreCase("Mamifero")) && (!variedad.equalsIgnoreCase("Ave"))
				&& (!variedad.equalsIgnoreCase("Reptil"))) {
			System.out.println("Introduce una opcion Correcta");
			variedad = sc.nextLine();
		}
		if (variedad.toLowerCase().equals("mamifero")) {
			Mamifero a = new Mamifero(nombreAnimal, genero, especie, edad);
			a.setTipoDesp();
			animales.add(a);
		} else if (variedad.toLowerCase().equals("ave")) {
			System.out.println("El ave es rapaz [introduzca el numero]");
			System.out.println("1. Si");
			System.out.println("Cualquier otro numero no");
			int comp = sc.nextInt();
			boolean esRapaz = comprobarBoolean(comp);
			System.out.println("Introduzca la longitud del pico");
			int longPico = sc.nextInt();
			animales.add(new Aves(nombreAnimal, genero, especie, edad, esRapaz, longPico));
		} else {
			System.out.println("Introduce el color de las escamas");
			String color = sc.nextLine();
			animales.add(new Reptil(nombreAnimal, genero, especie, edad, color));
		}
	}

	private static boolean comprobarBoolean(int comp) {
		if (comp == 1) {
			return true;
		}
		return false;
	}

	private static void eliminarAnimal(ArrayList<Animales> animales) {
		int num = animales.size();
		System.out.println("Introduzca el nombre del animal a eliminar");
		sc.nextLine();
		String nombre_animal = sc.nextLine();
		for (int i = 0; i < animales.size(); i++) {
			if (animales.get(i).getNombre().equalsIgnoreCase(nombre_animal)) {
				animales.remove(i);
				break;
			}
		}
		if (animales.size() == num) {
			System.out.println("Animal no encontrado");
		}

	}

	private static void crearEmpleado(ArrayList<EmpleadoZoo> empleado) throws CrearExcepciones {
		System.out.println("Introduzca el numero del empleado");
		int numEmpleado = sc.nextInt();
		for (int i = 0; i < empleado.size(); i++) {
			if (empleado.get(i).getNumEmpleado() == numEmpleado) {
				CrearExcepciones e = new CrearExcepciones("CuidadorExistenteException");
				throw e;
			}
		}
		System.out.println("Introduzca el nombre del empleado");
		sc.nextLine();
		String nombre_emp = sc.nextLine();
		System.out.println("Introduzca el apellido");
		String apellido = sc.nextLine();
		System.out.println("Introduzca el salario");
		Double salario = sc.nextDouble();
		empleado.add(new EmpleadoZoo(numEmpleado, nombre_emp, apellido, salario));
	}

	private static void eliminarEmpleado(ArrayList<EmpleadoZoo> empleado) {
		int num = empleado.size();
		System.out.println("Introduzca el nombre del empleado a eliminar");
		sc.nextLine();
		String nombre_empleado = sc.nextLine();
		for (int i = 0; i < empleado.size(); i++) {
			if (empleado.get(i).getNombre().equalsIgnoreCase(nombre_empleado)) {
				empleado.remove(i);
				break;
			}
		}
		if (empleado.size() == num) {
			System.out.println("Empleado no encontrado");
		}

	}

	private static Animales comprobarAnimal(String nombre, ArrayList<Animales> animales) {
		for (int i = 0; i < animales.size(); i++) {
			if (animales.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return animales.get(i);
			}
		}
		return null;
	}

	private static void AnadirAnimalaEmpleado(String nombre, ArrayList<EmpleadoZoo> empleado, Animales animal)
			throws CrearExcepciones {

		for (int i = 0; i < empleado.size(); i++) {
			if (empleado.get(i).getAnimalCuidado().equals(animal.getNombre())) {
				CrearExcepciones e = new CrearExcepciones("CuidadorDuplicadoException");
				throw e;
			}

		}
		for (int i = 0; i < empleado.size(); i++) {
			if (empleado.get(i).getNombre().equalsIgnoreCase(nombre)) {
				empleado.get(i).asignarAnimal(animal);
			}
		}
	}

	private static void nombreEmpleado(Animales animal, ArrayList<EmpleadoZoo> empleado) {
		int cont = 0;
		for (int i = 0; i < empleado.size(); i++) {
			if (empleado.get(i).getAnimalCuidado().equals(animal.getNombre())) {
				System.out.println(empleado.get(i).getNombre());
			}

		}
		if (cont == empleado.size()) {
			System.out.println("Animal sin cuidador");
		}

	}
}
