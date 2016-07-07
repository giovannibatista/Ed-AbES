package br.com.edabes.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public String FileToString(String file) throws IOException {
	String data = "";
	file = getPath(file);
	data = new String(Files.readAllBytes(Paths.get(file)), Charset.forName("UTF-8"));
	return data;
    }

    /*
     * Método importado do exemplo do site
     * https://dzone.com/articles/get-current-web-application
     * 
     */
    public String getPath(String file) throws UnsupportedEncodingException {
	String path = this.getClass().getClassLoader().getResource("").getPath();
	String fullPath = URLDecoder.decode(path, "UTF-8");
	String pathArr[] = fullPath.split("/WEB-INF/classes/");
	System.out.println(fullPath);
	System.out.println(pathArr[0]);
	fullPath = pathArr[0];

	String reponsePath = "";
	// to read a file from webcontent
	reponsePath = new File(fullPath).getPath() + File.separatorChar + file;
	return reponsePath;
    }

}
