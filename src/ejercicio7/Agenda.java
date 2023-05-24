package ejercicio7;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Agenda {

	public static void main(String[] args) {

		int opcion = 0; // Se guardara la opcion
		String nombre = null; // Se guardara el nombre del contacto
		long tlf = 0; // Se guardara el telefono del contacto
		Scanner read = null; // Creamos el Scanner

		BufferedWriter bw = null; // Creamos el BufferedWriter

		// Creamos una colletion de tipo TreeMap, donde guardaremos los datos
		TreeMap<String, Long> agenda = new TreeMap<String, Long>();

		// En un bloque try-catch
		try {
			// Creamos un objeto Scanner
			read = new Scanner(new FileReader("src\\ejercicio7\\Agenda.txt"));
			// Mientras lea la siguiente línea
			while (read.hasNextLine()) {
				// Creamos un array
				String[] contacts;
				// Se paramos los datos por el espacio
				contacts = read.nextLine().split(" ");
				// Guardamos los datos en la collection
				agenda.put(contacts[0], Long.valueOf(contacts[1]));
			}
			// Capturamos el error
		} catch (FileNotFoundException e) {
			// Mensaje de error
			System.out.println(e.getMessage());
		}

		// En otro bloque try-catch
		try {
			// Creamos un objeto BufferedWriter
			bw = new BufferedWriter(new FileWriter("src\\ejercicio7\\Agenda.txt", true));
			// Creamos otro objeto Scanner
			read = new Scanner(System.in);

			// Ordenamos que haga
			do {

				// Solicite opcion
				System.out.println("Seleccione una de las siguientes opciones: ");
				System.out.println("1. Nuevo contacto ");
				System.out.println("2. Buscar por nombre ");
				System.out.println("3. Mostrar todos ");
				System.out.println("4. Salir");
				opcion = read.nextInt();
				read.nextLine();

				// Creamos un switch
				switch (opcion) {
				// En el primer caso, añadir un nuevo contacto
				case 1:

					// Si el tamaño de la agenda es menor a 20
					if (agenda.size() < 20) {
						// Pedirá los datos
						System.out.println("Introduzca el nombre del contacto: ");
						nombre = read.next();
						read.nextLine();
						System.out.println("Introduzca el número de teléfono:");
						tlf = read.nextLong();

						// Mientras que el nombre esté vacío o el telefono sea menor que 0
						while (nombre.isEmpty() || tlf < 0) {
							// Solicitamos de nuevo los datos
							System.out.println("Por favor, introduzca de nuevo los datos correctamente");
							System.out.println("Introduzca el nombre del contacto");
							nombre = read.next();
							read.nextLine();
							System.out.println("Introduzca el número de teléfono:");
							tlf = read.nextLong();
						}

						// Si el número NO está registrado
						if (!agenda.containsValue(tlf)) {
							// Lo añadirá a la agenda
							agenda.put(nombre, Long.valueOf(tlf));
							System.out.println("Contacto añadido correctamente");
							System.out.println();
							// Por lo contrario
						} else {
							// Le mostrará un mensaje de que ya existe el contacto
							System.err.println("El contacto ya se encuentra registrado");
							System.out.println();
						}
						// En caso contrario
					} else {
						// Mensaje de error
						System.err.println("La agenda está llena");
						System.out.println();
					}
					break;
				// En el caso 2, buscar un contacto y mostrar su numero de tlf
				case 2:
					// Pedimos el nombre
					System.out.println("Introduzca el nombre del contacto que desea buscar: ");
					nombre = read.next();
					read.nextLine();

					// Si el nombre está en la collection
					if (agenda.containsKey(nombre)) {
						// Mostramos el número de teléfono
						System.out.print("El teléfono del contacto " + nombre + " es: ");
						System.out.println(agenda.get(nombre));
						System.out.println();
						// En caso contrario
					} else {
						// Mensaje de error
						System.err.println("El contacto no se encuentra");
						System.out.println();
					}

					break;
				// En el caso 3, listar los contactos
				case 3:
					System.out.println("LISTA DE CONTACTOS");
					System.out.println("_______________________________________");
					// Recorremos la collection
					for (Entry<String, Long> values : agenda.entrySet()) {
						// Mostramos el nombre y el teléfono
						System.out.println("- Nombre: " + values.getKey());
						System.out.println("  Número de teléfono: " + values.getValue());
					}
					break;
				// En el caso 4, salir del programa y guardar los datos en el fichero
				case 4:
					// Recorremos la collection
					for (Entry<String, Long> values : agenda.entrySet()) {
						// Escribimos los datos
						bw.write(values.getKey() + " " + values.getValue());
						bw.newLine();
					}

					System.out.println("Saliendo del programa...");

					break;
				// En el default
				default:
					// Mensaje de error
					System.err.println("ERROR, introduzca una opción válida");
				}

				// Mientras que la opcion sea distinta de 4
			} while (opcion != 4);

			// Capturamos los errores
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
			// Finalmente
		} finally {
			// En un bloque try-catch
			try {
				// Vaciamos el flujo
				bw.flush();
				// Cerramos el flujo
				bw.close();
				// Cerramos el Scanner
				read.close();
				// Capturamos la exception
			} catch (IOException e) {
				// Mensaje de error
				System.err.println(e.getMessage());
			}
		}

	}
}
