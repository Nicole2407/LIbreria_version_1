package lib_genericP65v0;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Files {
private static Pattern pattern;
private Generic<String,File> data;
private boolean flag = false;

public Files(String pathname) {
	data = new Generic<>(pathname,new File(pathname));
}

/**
* Metodo que permite escribir informacion en un archivo
* @param text -> Es el texto a escribir en el archivo
* @param allow -> Es el permiso de sobreescritura
* @return
* @
*/

public boolean writerFile(String text,boolean allow)throws IOException{
	FileWriter archivo = new FileWriter(data.getAttribute3().getAbsolutePath(),!allow);
	archivo.write(text+"\n");
	archivo.close();
	return true;
		
}
/**
* Metodo para leer los datos de un archivo
* @return String
* @throws IOException
*/


public String readerFile() throws IOException{
	data.setAttribute2("");
	FileReader reader =new FileReader(data.getAttribute3().getAbsolutePath());
	int caracteres;
	while((caracteres = reader.read())!=-1) {
		data.setAttribute2(data.getAttribute2()+String.valueOf((char)caracteres));
	}
	reader.close();
	
	return data.getAttribute2();
}

/**
* Metodo para crear archivo y directorios
* @param tipo 1 crear un archivo, y 0 un directorio
* @return
*/

public boolean create(int tipo) {
	switch(tipo) {
	case 0:
		if(!data.getAttribute3().exists()) {
			flag = data.getAttribute3().mkdir();
		}
		break;
	case 1:
		if(!data.getAttribute3().exists()) {
			try {
				flag = data.getAttribute3().createNewFile();
			} catch (IOException e) {
				flag = false;
			}
		}
		break;
	default:
		flag = false;
		break;

	}
	return flag;
}
/**
* Metodo para validar una cadena mediante de una ER
* @param chain cadena
* @param ER Patron
* @return
*/


public static boolean validateByER(String text,String ER) {
	return text.matches(ER);
}
/**
* Metodo para reemplazar una palabra en un texto
* @param text Es el texto de analisis
* @param replace Es la palabra de reemplazo
* @param SearchWord Es la palabra a buscar
* @return
*/


public static String searchReplace(String text,String replace,String SearchWord) {
	pattern = Pattern.compile(SearchWord);
	Matcher analisis = pattern.matcher(text);
	return analisis.replaceAll(replace);
}

/**
* Metodo para obtener las palabras que cumplan una expresion regular
* @param text Texto para analizar
* @param ER Expresion Regular
* @return List<String>
*/

public List<String> findWords(String text,String ER){//Voy a poner un ojo a que explique mañana JAJJA *-*-**-*-*-*-
	pattern = Pattern.compile(ER);
	data.setAttArray1(text.split("(\s+|[,.;])"));
	for(String word:data.getAttArray1()) {
		Matcher analisis = pattern.matcher(word);
		if(analisis.find()) {
			data.addElementArray(analisis.group());
		}
	}
	return data.getAttList2();
}//oooh okas grax

public File getFile() {
	return data.getAttribute3();
}

public void setFile(File nwFile) {
	data.setAttribute3(nwFile);
}

/**
* Lista los archivos de un directorio
* @return
*/

public String[]listFiles(){
	if(data.getAttribute3().isDirectory()) {
		return data.getAttribute3().list();
	}else {
		return null;
	}
}

/**
* Metodo para devolver un listado de archivos o de directorios
* @param tipo tipo==1 Retorna directorios, tipo==0 Retorna archivos
* @return String[]
*/

public List<String> listFilesoDirectory(int tipo){
	data.setAttArray1(listFiles());
	if(data.getAttArray1().length>0) {
		for(String file:data.getAttArray1()) {
			data.setAttribute4(new File(data.getAttribute3().getAbsolutePath()+"/"+file));
			if(tipo ==1) {
				if(data.getAttribute4().isDirectory()) {
					data.addElementList2(file);
				}
			}else if(tipo == 0){
				if(data.getAttribute4().isFile()) {
					data.addElementList2(file);
				}
			}
		}
	}
	return data.getAttList2();//un STring tonc? 
}

/**
* Metodo para obtener un archivo del usando FileChooser
* @param pn
* @param extension
* @return
*/

public boolean getFileChooser(JFrame pn,String extension) {
	JFileChooser file = new JFileChooser();
	file.setAcceptAllFileFilterUsed(false);
	file.addChoosableFileFilter(new FileNameExtensionFilter(extension + "files",new String[]{extension}));
	file.setFileSelectionMode(JFileChooser.FILES_ONLY);
	int flag = file.showOpenDialog(pn);
	
	if(flag == file.APPROVE_OPTION) {
		setFile(new File(file.getSelectedFile().getAbsolutePath()));
		return true;
	}else {
		return false;
	}

}

}
