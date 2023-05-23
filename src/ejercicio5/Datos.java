package ejercicio5;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Datos {

	public static void main(String[] args) {
		Scanner read= new Scanner (System.in);
		
		String nombre=""; 
		int edad=0;
		boolean actualizacion=false;
		
		
		FileWriter file;
		
		try {
			file= new FileWriter("src\\ejercicio5\\Datos.txt", true);
			
			System.out.println("Introduzca su nombre");
			nombre=read.next();
			System.out.println("Introduzca su edad");
			edad=read.nextInt();
			
			file.write(nombre+", "+edad);
			
		}catch(FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.err.println("No se puede abrir el archivo");
			System.err.println(e.getMessage());
		}
		
	}

}
