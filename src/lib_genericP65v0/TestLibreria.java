package lib_genericP65v0;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestLibreria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Generic<String,Integer> g0 = new Generic<>();
//		
//		Generic<String,Integer> g1 = new Generic<>("Test1");
//		Generic<String,Integer> g2 = new Generic<>("Test2",10);
//		Generic<String,Integer> g3 = new Generic<>("Test3","Marca3",20);
//		Generic<String,Integer> g4 = new Generic<>("Test4","Marca4",30,40);
//		Generic<String,Integer> g5 = new Generic<>("Test5",10,14,15,20,15);
//		
//		System.out.println(g1.toString());
//		System.out.println(g2.toString());
//		System.out.println(g3.toString());
//		System.out.println(g4.toString());
//		
//		System.out.println(g5.getAttArray2()[3]);
//		// el primer tipo agarra un tipo int para el switch case, y el segundo agarra los valores del array
//		System.out.println("Numero mayor:"+ g0.typesElements(new Generic<Integer,Double>(1,10.25,11.02,9.25)));

		/***
		 * TEST DE LA VERSION 1.0
		 * AGREGADO LA CLASE FILES
		 */
		
		//EJ1
		Files objFile1 = new Files("C:/testFiles");//ruta absoluta
		Files objFile2 = new Files("testFiles");//ruta relativa 
	//	objFile1.create(0);//ruta absoluta directorio
		objFile2.create(0);//ruta relativa
	//	objFile1.setFile(new File(objFile1.getFile().getAbsolutePath(),"notas.doc"));
		objFile1.create(1);
		objFile2.setFile(new File("testFiles/logs.txt"));//crea en mi proyecto la carpeta o txt archivo
		objFile2.create(1);
		try {//con esto escribo o sobreescribo dentro del archivo//este metodo siempre entre try catch
			objFile2.writerFile("Test funcionamiento4", false);//(con true)sobre escribir sobre el archivo
			System.out.println(objFile2.readerFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(objFile1.validateByER("1A58", "^[0-3][A-Z][0-9]{3}$")) {
			System.out.println("Cadena aceptada");
		}
		
		//EJ2 ingresar un cuento y que busque palabras especificas
		try {//escriba y buscar el archivo para leer y despues reemplazar las palabras true
			//Reemplazo prueba por test
			objFile2.writerFile(objFile2.searchReplace(objFile2.readerFile(), "Prueba","Test"), true);
			//EJ3
			objFile1.writerFile("- Liebre, ¿vamos hacer una carrera? Estoy segura de poder ganarte.\r\n"
					+ "\r\n"
					+ "- ¿A mí? Preguntó asombrada la liebre.\r\n"
					+ "\r\n"
					+ "- Sí, sí, a ti, dijo la tortuga. Pongamos nuestras apuestas y veamos quién gana la carrera.\r\n"
					+ "\r\n"
					+ "La liebre, muy engreída, aceptó la apuesta prontamente.\r\n"
					+ "\r\n"
					+ "Así que todos los animales se reunieron para presenciar la carrera. El búho ha sido el responsable de señalizar los puntos de partida y de llegada. Y así empezó la carrera:\r\n"
					+ "\r\n"
					+ "Astuta y muy confiada en sí misma, la liebre salió corriendo, y la tortuga se quedó atrás, tosiendo y envuelta en una nube de polvo. Cuando empezó a andar, la liebre ya se había perdido de vista. Sin importarle la ventaja que tenía la liebre sobre ella, la tortuga seguía su ritmo, sin parar.\r\n"
					+ "\r\n"
					+ "La liebre, mientras tanto, confiando en que la tortuga tardaría mucho en alcanzarla, se detuvo a la mitad del camino ante un frondoso y verde árbol, y se puso a descansar antes de terminar la carrera. Allí se quedó dormida, mientras la tortuga seguía caminando, paso tras paso, lentamente, pero sin detenerse.\r\n"
					+ "\r\n"
					+ "No se sabe cuánto ads tiempo la liebre se quedó dormida, pero cuando ella se despertó, vio con pavor que la tortuga se encontraba a tan solo tres pasos de la meta. En un sobresalto, salió corriendo con todas sus fuerzas, pero ya era muy tarde: ¡la tortuga había alcanzado la meta y ganado la carrera!\r\n"
					+ "\r\n"
					+ "Ese día la liebre aprendió, en medio de una gran humillación, que no hay que burlarse jamás de los demás. También aprendió que el exceso de confianza y de vanidad, es un obstáculo para alcanzar nuestros objetivos. Y que nadie, absolutamente nadie, es mejor que nadie.", true);
			List<String> words = objFile1.findWords(objFile1.readerFile(), "^[a]\\w[s]$");//buscar palabras que empiecen con a y terminen en s
			for(String word:words) {//****---REVISAR QUE IMPRIMA BIEN ESTA COSA DE VERIFICAR SI HAY PALABRAS EN COMUN
				System.out.println(word);//imprime las palabras con similitudes encontradas
			}
			
			//Ej4 buscar archivo txt y que lea lo que esta dentro del archivo
			objFile1.getFileChooser(null, "txt");//se abre una ventana de dialogo para seleccionar el  tipo de archivo que busco 
			System.out.println(objFile1.readerFile());//lee la info que esta en el archivo 
			//Ej5 listar lo que esta todo dentro del src
			objFile1.setFile(new File("src"));
			words = objFile1.listFilesoDirectory(1);//listar lo que hay dentro de los archivos
			for(String w:words ) {
				System.out.println(w);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
