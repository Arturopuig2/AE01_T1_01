package es.florida.AE01_1_T1_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Date;

public class AE01_T1_1 {
		
//Menú: muestras las opciones a elegir
	public static void main(String[] args) throws IOException {	
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);

		System.out.println("MENÚ");
		System.out.println("1. Obtener info ");
		System.out.println("2. Crear carpeta ");
		System.out.println("3. Crear archivo ");
		System.out.println("4. Eliminar ficheros ");
		System.out.println("5. Eliminar carpeta");		
		System.out.println("6. Renombrar");
		System.out.print("Indicar número: ");
		String numeroString= br.readLine();
		int numero =Integer.parseInt(numeroString);
		switch (numero) {
		case 1:
			getInformacion(args);
			break;
		case 2:
			creaCarpeta(args);
			break;
		case 3:
			creaFichero(args);
			break;
		case 4:
			eliminaFichero(args);
			break;
		case 5:
			eliminaCarpeta(args);
			break;
			//No me funciona. La carpeta está vacía pero no se borra.			
		case 6:
			renombraFichero(args);
			break;

		default:
			System.out.println("Fin");
		}	
	}
	
	//Método: getInformación
	//Descripción: método que devuelve información sobre el directorio/archivo que se le pasa como parámetro.
	//Parámetros de entrada: directorio o fichero.
	//Parámetros de sálida: no.
	public static void getInformacion(String[] args) {
			String directorio=args[0];
			System.out.println("Directorio: "+directorio);
			
			File file=new File(directorio);
			System.out.println("Nombre: "+file.getName());	
			System.out.println("¿Es de tipo directorio?: "+file.isDirectory());
			System.out.println("¿Es de tipo archivo?: "+file.isFile());
			System.out.println("Ubicación: "+file.getAbsolutePath());
			System.out.println("Última modificación: "+new Date(file.lastModified()));
			System.out.println("¿Es visible?: " +file.isHidden());
			
			
			if(file.isFile()) {
				System.out.println("Tamaño en bytes del fichero: "+file.getTotalSpace());				
			}else {
				System.out.println("Espacio disponible en el directorio: "+file.getUsableSpace());
				System.out.println("Espacio libre en el directorio: "+file.getFreeSpace());
				System.out.println("Espacio total en el directorio: "+file.getTotalSpace());
				
				String[] listaArchivos= file.list();
				int numeroDeArchivos=listaArchivos.length;
				System.out.println("Número de archivos: " +numeroDeArchivos);				
				}
			}

	//Método: crearCarpeta
	//Descripción: método que crea una carpeta que se le pasa como parámetro.
	//Parámetros de entrada: nombre carpeta.
	//Parámetros de sálida: no.
	public static void creaCarpeta(String[] args) throws IOException {
		File carpeta=new File("NuevaCarpeta");
		carpeta.mkdirs();		
	}

	//Método: crearFichero
	//Descripción: método que crea un fichero que se le pasa como parámetro.
	//Parámetros de entrada: nombre fichero.
	//Parámetros de sálida: no.
	public static void creaFichero(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Indicar nombre archivo con extensión: ");
		String nombreFile=br.readLine();		

		File fichero=new File("NuevaCarpeta",nombreFile);		
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	//Método: eliminarFichero
	//Descripción: método que elimina un fichero que se le pasa como parámetro.
	//Parámetros de entrada: nombre fichero.
	//Parámetros de sálida: no.
	public static void eliminaFichero(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Indicar nombre de archivo con extensión: ");
		String nombreFile=br.readLine();
		
		File fichero=new File("NuevaCarpeta",nombreFile);
		if(fichero.exists()) {
			fichero.delete();
			System.out.println("Fichero borrado");
			
		}else {
			System.out.println("El fichero no existe");
		}		
	}	
	
	//Método: eliminarCarpeta
	//Descripción: método que elimina una Carpeta que se le pasa como parámetro.
	//Parámetros de entrada: nombre carpeta.
	//Parámetros de sálida: no.
	public static void eliminaCarpeta(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Indicar nombre de carpeta: ");
		String nombreCarpeta=br.readLine();
		
		File carpeta=new File(nombreCarpeta);
		
		if(carpeta.exists()) {
			carpeta.delete();
			System.out.println("Carpeta borrada");
			
		}else {
			System.out.println("La Carpeta no existe");
		}		
	}		
	
	//Método: renombrar
	//Descripción: método que renombra un fichero que se le pasa como parámetro.
	//Parámetros de entrada: nombre fichero.
	//Parámetros de sálida: no.
	public static void renombra(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Indicar nombre del fichero o carpeta a renombrar: ");
		String nombreFichero=br.readLine();
		File oldfield=new File(nombreFichero);	
		
		System.out.print("Indicar nuevo nombre: ");		
		String nuevoNombreFichero=br.readLine();
		File newfield=new File(nuevoNombreFichero);	
		
		if(oldfield.renameTo(newfield)) {
			System.out.println("Nombre cambiado");	
		}else {
			System.out.println("Error");
		}		
	}	
}