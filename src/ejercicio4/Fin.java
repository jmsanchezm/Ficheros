package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fin {

	public static void main(String[] args) {

		String text = ""; // Se guardara el texto introducido

		BufferedWriter bw = null; // Creamos una variable de tipo BufferedWriter

		// Creamos el Scanner
		Scanner read = new Scanner(System.in);

		// En un bloque try-catch
		try {
			// Creamos un objeto para escribir en el fichero
			bw = new BufferedWriter(new FileWriter("src\\ejercicio4\\Fin.txt"));

			// Solicitamos la palabra
			System.out.println("Introduzca una palabra");
			text = read.next();

			// Mientras que la palabra sea distinta de fin
			while (!text.equals("fin")) {
				// La escribimos en el fichero
				bw.write(text + "\n");
				
				// Y pedimos otra palabra
				text = read.next();
			}

			// Capturamos las exceptions
		} catch (FileNotFoundException e) {
			// Mostramos mensaje de error
			System.err.println("No se ha encontrado el fichero");
			System.err.println(e.getMessage());
		} catch (IOException e) {
			// Mostramos las excetptions
			System.err.println("No se ha logrado abrir el fichero");
			System.err.println(e.getMessage());
		} finally {
			try {
				// Vaciamos el bufer de salida, escribiendolo en el fichero
				bw.flush();
				// Cerramos el flujo de salida
				bw.close();
				// Cerramos el Scanner
				read.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		}

	}

}
