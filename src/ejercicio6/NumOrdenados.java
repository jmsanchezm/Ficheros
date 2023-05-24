package ejercicio6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumOrdenados {

	public static void main(String[] args) {

		int numero; //Se guaradara el numero
 
		Scanner read=null; //Se guardara el Scanner 

		BufferedWriter writer=null; //Creamos una variable tipo BufferedWriter

		//Creamos una lista 
		ArrayList<Integer> collection = new ArrayList<Integer>();

		//Bloque try-catch
		try {
			//Creamos el objeto de tipo Scanner
			read = new Scanner(new FileReader("src\\ejercicio6\\NumDesordenados.txt"));
			
			//Mientras que lea una linea
			while (read.hasNextInt()) {
			//Leemos el número	
			numero = read.nextInt();
			//Guardamos el número en la collection
			collection.add(numero);
			}
			
			//Ordenamos la collection
			Collections.sort(collection);
			
			//Creamos un objeto tipo BufferedWriter
			writer= new BufferedWriter (new FileWriter("src\\ejercicio6\\NumOrdenados.txt",true));
			
			//Recorremos la collection
			for (Integer values: collection) {
				//Escribimos los valores en el fichero nuevo
				writer.write(String.valueOf(values));
				//Salto de línea
				writer.newLine();
			}
			
		//Capturamos la exception	
		} catch (FileNotFoundException e) {
			//Mostramos el error
			System.err.println(e.getMessage());
			System.err.println("El fichero no se ha podido encontrar");
		//Capturamos el error	
		} catch (IOException e) {
			//Mostramos el error
			System.err.println(e.getMessage());
			System.err.println("El fichero no se ha podido abrir");
		// Finalmente
		}finally {
			//En un bloque try-catch
			try {
				//Vaciamos 
				writer.flush();
				writer.close();
				read.close();
			}catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

	}

}
