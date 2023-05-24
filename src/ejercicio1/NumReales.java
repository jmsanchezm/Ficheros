package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class NumReales {

	public static void main(String[] args) {
		
		int contador = 0; //Se guardara el contador 
		int suma = 0; //Se guaradara la suma de los números
		double media=0; //Se guaradara la media de los numeros
		
		//Creamos el Scanner
		Scanner read;

		//Abrimos un bloque try-catch
		try {
			
			// Inicializamos el Scanner con el nombre del fichero que queremos leer
			read = new Scanner(new FileReader("src\\ejercicio1\\NumerosReales.txt"));
			
			//mientras que siga leyendo caracteres
			while (read.hasNext()) {
				//Se irán sumando a la variable suma
				suma+= read.nextInt();
				//Iremos contando el número de caracteres
				contador++;
			}
			//Calculamos la media
			media = suma/contador;
			
			//Mostramos los resultado
			System.out.println(suma);
			System.out.println(media);

			//Se capturara el siguiente error
		} catch (FileNotFoundException e) {
			//Mostramos que ha habido un error
			System.err.println("No se ha encontrado el fichero");
			System.err.println(e.getMessage());
		}catch (IOException e) {
			System.err.println("No se puede abrir el fichero");
			System.err.println(e.getMessage());
		}

		
		
	}

}
