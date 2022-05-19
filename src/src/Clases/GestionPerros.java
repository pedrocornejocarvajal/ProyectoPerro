package src.Clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;



//import Clases.Alumno;

public class GestionPerros {

	/*Interfaz
	 * Comentario: inserta un registro de tipo Alumno en un ficherio de texto
	 * Prototipo: void escribeAlumno(String fichero, alumno)
	 * Entradas: una cadena y un objeto de tipo alumno
	 * Precondiciones: el fichero debe existir
	 * Salidas: ninguna
	 * Postcondiciones: el fichero tendra un registro mas
	 * */
	public static void escribeAlumno(String rutaFichero, Perro nuevo){
		File fichero = null;
		RandomAccessFile raf = null;
		
		try{
			fichero = new File(rutaFichero);
			raf = new RandomAccessFile(fichero, "rw");
			raf.seek(raf.length());
			raf.writeInt(nuevo.getId());
			raf.writeBytes(nuevo.getNombre()+"\n");
			raf.writeBytes(nuevo.getRaza()+"\n");
			raf.writeBytes(nuevo.getColor()+"\n");
			raf.writeBoolean(Boolean.parseBoolean(nuevo.isConChapa()+"\n"));
			raf.writeInt(nuevo.getEdad());
		} catch(NullPointerException | IOException npe){
			npe.printStackTrace();
		} finally{
			try{
				if(fichero!=null) {
					assert raf != null;
					raf.close();
				}
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	/*Interfaz
	 * Comentario: lee un registro de un perro segun su posicion
	 * Prototipo perro leePerro(String  rutaFichero,int pos)
	 * Entradas: una cadena y un entero
	 * Precondiciones: la ruta del fichero debe existir
	 * Salida: un objeto de tipo Alumno
	 * Postcondiciones: Asociado al nombre se devuelve el objeto leido del registro indicado*/
	public static Perro leePerro(String rutaFichero, int pos){
				
		File fichero;
		RandomAccessFile raf = null;
		
		int id=0;
		int edad = 0;
		String nombre="";
		String raza="";
		String color="";
		boolean conChapa=false;
		
		try{
			fichero = new File(rutaFichero);
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0); //apunta al principio del fichero
			raf.seek((long) (Perro.SIZE + 2) *(pos)); //+2 por los dos caracteres de salto de linea
			id=raf.readInt();
			nombre=raf.readLine();
			raza=raf.readLine();
			color=raf.readLine();
			conChapa=raf.readBoolean();
			edad=raf.readInt();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(raf!=null)
					raf.close();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		
		return (new Perro(id,nombre,raza,color,conChapa,edad));
	}
	
	/*Interfaz
	 * Comentario: devuelve una lista de tipo Perro buscados en el fichero
	 * Prototipo List <Perro> buscaPerroPorNombre(String rutaFichero, String nombre)
	 * Entradas: dos cadenas
	 * Precondiciones: la ruta del fichero debe existir
	 * Salida: una lista de Perros
	 * Postcondiciones: Asociado al nombre se devuelve una lista con los perros que coincidan en el nombre pasado por parametro*/
	
	public static List <Perro> buscaPerroPorNombre(String path, String nombreBusqueda){
		File fichero;
		RandomAccessFile raf = null;
		long tamanoFichero;
		int id;
		int edad;
		String nombre;
		String raza;
		String color;
		boolean conChapa;
		List <Perro> aux = new ArrayList<>();
		
		try{
			fichero = new File(path);
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0);
			tamanoFichero=raf.length(); //calculo el tama�o del fichero EOF
			while(raf.getFilePointer()<tamanoFichero){

				id=raf.readInt();
				nombre=raf.readLine();
				raza=raf.readLine();
				color=raf.readLine();
				conChapa=raf.readBoolean();
				edad=raf.readInt();
				if(nombre.contains(nombreBusqueda)){
					aux.add(new Perro(id,nombre,raza,color,conChapa,edad)); //inserto el Perro en la lista
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(raf!=null)
					raf.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return aux;
	}
	
	public static void main(String[] args){
		Perro uno = new Perro(1,"Daniel","BODEGUERO","verde",false,9);
		Perro dos = new Perro(2,"Pepe","BULLTERRIER","negro",true,5);
		Perro tres = new Perro(3,"antonio","CHIHUAHUA","rojo",false,2);
		Perro cuatro = new Perro(4,"juanjo","DOGO","blanco",true,1);
		Perro cinco = new Perro(51,"gato","NISUPU","azul",false,4);
				
		escribeAlumno("Perros.dat",uno);
		escribeAlumno("Perros.dat",dos);
		escribeAlumno("Perros.dat",tres);
		escribeAlumno("Perros.dat",cuatro);
		escribeAlumno("Perros.dat",cinco);
		
		System.out.println(leePerro("Perros.dat",1));
		System.out.println(leePerro("Perros.dat",3));
		
		
		List <Perro> perros = buscaPerroPorNombre("Perros.dat", "gato");
		
		for (Perro perro : perros) {
			System.out.println(perro);
		}
		
	}//main
		
}//clase
