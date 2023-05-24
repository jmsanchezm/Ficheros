package ejercicio3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Alumnos {

	public static void main(String[] args) {
		Scanner read=null; // Creamos la variable de tipo Scanner
		int edad = 0; // Se guardara la edad del alumno
		String nombre; // Se guardara el nombre del alumno
		double estatura = 0; // Se guardara la estatura del alumno
		int sumaEdad = 0; // Se guardara la suma de las edades
		int sumaEstatura = 0; // Se guardara la suma de las estaturas
		int cont = 0; // Irá contando el numero de alumnos
		double mediaEdad = 0;
		double mediaEst = 0;

		// En un bloque try-catch
		try {

			/*
			 * Creamos el objeto de tipo Scanner que tendrá como flujo de entrada el
			 * siguiente fichero
			 */
			read = new Scanner(new FileReader("src\\ejercicio3\\Alumnos.txt"));

			read.useLocale(Locale.US);

			// Mientras pueda leer una línea
			while (read.hasNextLine()) {
				// Creamos un array
				String[] datos;
				// Almacenamos en el la línea, separando segun los espacios
				datos = read.nextLine().split(" ");

				// Guardamos en variables los datos del alumno
				nombre = datos[0];
				edad = Integer.parseInt(datos[1]);
				estatura = Double.parseDouble(datos[2]);

				// Se ira sumando a una variable suma
				sumaEdad += edad;
				sumaEstatura += estatura;
				cont++;

				// Imprimimos el nombre
				System.out.println("Nombre: "+nombre);

			}

			//Calculados las medias de la edad y de la estatura
			mediaEdad = (double)sumaEdad / cont;
			mediaEst = sumaEstatura / cont;

			// Imprimimos el resultado de la media
			System.out.println("Media de edad: " +mediaEdad);
			System.out.println("Media de Estatura: " + mediaEst);

			// Capturamos el error de no encontrar el fichero
		} catch (FileNotFoundException e) {
			System.err.println("No se ha logrado encontrar el fichero");
			System.err.println(e.getMessage());

			// Capturamos el error de no poder abrir el fichero
		} catch (IOException e) {
			//Mostramos el mensaje de error
			System.err.println("No se ha logrado abrir el fichero");
			System.err.println(e.getMessage());
		// Finalmente	
		}finally {
			//Cerramos el Scanner 
			read.close();
		}

	}

}
