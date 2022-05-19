package src.Clases;/*
 * Clase Perro
 * -----------------------------
 * 
 * 	Propiedades:
 * 		- id: entero
 * 		- Nombre: cadena		
 * 		- raza: cadena	enum
 * 		- color: cadena
 * 		- chapa: booleano
 * 		- edad: enter
 * 
 * 	Metodos:
 * 		- int getMatricula()
 * 		- String getNombre()
 * 		- String getApellidos()
 * 		- int[] getNotas()
 * 		- double getNotaMedia()
 * 		- void setNotas(int[] notas)
 * 		- void preparaCadena()
 * 		- void Leerperro()
 * */

//package alumno;

import src.Enums.Raza;

import java.util.Scanner;

public class Perro {

	//variables de clase

	public static int SIZE = 45+(4*5);
	
	//Variables de instancia
	private int id;
	private String nombre;
	private Raza raza;
	private String color;
	private boolean conChapa;
	private int edad;
			
	
	//constructor por defecto
	public Perro() {
		id =0;
		nombre="indefinido";
		raza = Raza.valueOf("NISUPU");
		color ="indefinido";
		conChapa =false;
		edad = 0;
	}
	
	//constructor con parametros
	public Perro(int id, String nombre, String raza,String color,boolean conChapa, int edad){

		try
		{
			this.id = id;
			this.nombre=nombre;
			this.raza = Raza.valueOf(raza);
			this.color = color;
			this.conChapa = conChapa;
			this.edad = edad;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//Getters
	public int getId(){
		return this.id;
	}
	 
	public String getNombre(){
		return this.nombre;
	}
	 
	public Raza getRaza(){
		return this.raza;
	}
	public String getColor() {
		return color;
	}

	public boolean isConChapa() {
		return conChapa;
	}

	public int getEdad() {
		return edad;
	}

	
//	/*Interfaz
//	 * Comentario: prepara el nombre para que siempre tenga como tama�o fijo lo que indique MAXNOMBRE
//	 * Prototipo: void preparaNombre()
//	 * Precondiciones: ninguna
//	 * Entradas: ninguna
//	 * Salida: ninguna
//	 * Postcondiciones: ninguna*/
//	private void preparaCadena(){
//				nombre=nombre+" ";
//				raza = raza +" ";
//	}
	
	/*Interfaz
	 * Comentario: Devuelve una cadena representativa del objeto
	 * Prototipo: String toString()
	 * Precondiciones: ninguna
	 * Entradas: ninguna
	 * Salida: una cadena
	 * Postcondiciones: Asociado al nombre se devuelve una cadena representativa del objeto*/	
	public String toString(){
		
		String cadena;
		cadena ="Su id es: "+ id +"\nSu nombre es: "+ nombre +"\nSu raza es: "+ raza+"\nSu color es: " + color +"\nTiene chapa: "+ conChapa+"\nSu edad es: "+edad;
		return cadena+"\n";
		
	}
	
	/*Interfaz
	 * Comentario: lee los datos de un objeto de teclado
	 * Prototipo: Empleado leerAlumno(void)
	 * Precondiciones: ninguna
	 * Entradas: ninguna
	 * Salidas: un objeto de tipo alumno
	 * Postcondiciones: Asociado al nombre se devuelve un objeto de tipo Alumno*/
	public Perro leerPerro(){
		
		Scanner teclado = new Scanner(System.in);
		int id;
		String nombre;
		String raza;
		String color;
		boolean conChapa;
		int edad;
		
		System.out.print("Introduzca id: ");
		id = teclado.nextInt();
		
		System.out.print("Introduzca nombre: ");
		nombre = teclado.next();
		
		System.out.print("Introduzca raza: ");
		raza = teclado.next();

		System.out.print("Introduzca color: ");
		color = teclado.next();

		System.out.print("Introduzca si tiene chapa: ");
		conChapa = teclado.nextBoolean();
		System.out.print("Introduzca la edad: ");
		edad = teclado.nextInt();
		
		return new Perro(id,nombre,raza,color,conChapa,edad);
	}

}//clase alumno
