package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Datos {

	public static void main(String[] args) {
		
		//Creamos el Scanner 
		Scanner read = new Scanner(System.in);

		String nombre = ""; //Se guardara el nombre del usuario
		int edad = 0; //Se guardara la edad del usuario

		//Creamos una variable tipo BufferedWriter
		BufferedWriter file=null;

		//En un bloque try-catch 
		try {
			//Creamos un objeto donde tendra como flujo de entrada un fichero
			file = new BufferedWriter(new FileWriter("src\\ejercicio5\\Datos.txt", true));

			// Solicitamos datos
			System.out.println("Introduzca su nombre");
			nombre = read.next();
			System.out.println("Introduzca su edad");
			edad = read.nextInt();

			//Escribimos el nombre y la edad en el fichero
			file.write(nombre + ", " + edad);
			//Añadimos una línea
			file.newLine();
			

		//Capturamos las exceptions
		} catch (FileNotFoundException e) {
			//Mostramos que hay una exception
			System.err.println("No se ha encontrado el fichero");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			//Mostramos que hay una exception
			System.err.println("No se puede abrir el archivo");
			System.err.println(e.getMessage());
			
		//Finalmente	
		}finally {
			//En un  bloque try-catch 
			try {
				//Vaciamos el flujo de salida
				file.flush();
				//Y cerramos el flujo de salida
				file.close();
				//Cerramos el Scanner
				read.close();
	
			//Capturamos la exception	
			}catch (IOException e) {
				//Mostramos mensaje de error
				System.err.println(e.getMessage());
			}
		}

	}

}
