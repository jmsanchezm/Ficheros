package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Enteros {
	
	public static void main(String[] args) {

		//Creamos una variable tipo Scanner 
		Scanner read=null;
		
		double media; //Se guardara la media de los numeros
		int suma=0; //Se guardara la suma de los números
		int cont=0; //Irá contando la cantidad
		
		//En un bloque try-catch 
		try {
			//Creamos un objeto Scanner, con el flujo de entrada de un fichero 
			read= new Scanner(new FileReader("src\\ejercicio2\\Enteros.txt"));
			
			//Mientras que lea otra línea
			while (read.hasNext()) {
				//Se sumara a la variable suma el numero entero
				suma+=read.nextInt();
				//Contara el número
				cont++;
			}
			
			//Calulamos la media
			media=suma/cont;
			
			//Mostramos la media y la suma
			System.out.println(suma);
			System.out.println(media);
		//Capturamos la exceptions	
		}catch (FileNotFoundException e) {
			//Mostramos mensaje de error
			System.err.println("No se ha encontrado el fichero");
			System.err.println(e.getMessage());
		}catch (IOException e) {
			//Mostramos el mensaje de error
			System.err.println("No se ha podido abrir el fichero");
			System.err.println(e.getMessage());
		//Finalmente 	
		} finally{
			//Cerramos el Scanner 
			read.close();
		}
		
		
	}
}
