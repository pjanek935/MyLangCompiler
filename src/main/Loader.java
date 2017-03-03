package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
	
	public static final String FILES_LOCATION = "files/";
	public static final String INCLUDE_PATTERN = "#[ \t\f\r\n]*(include|INCLUDE)[ \t\f\r\n]*(<|\")([a-z]|[A-Z]|_|[0-9])+(.([a-z]|[A-Z]|_|[0-9])+)?(>|\")";
	public static final String FILE_PATTERN = "(<|\")([a-z]|[A-Z]|_|[0-9])+(.([a-z]|[A-Z]|_|[0-9])+)?(>|\")";
	
	public Loader() {
		
	}
	
	public static void save(ArrayList<String> instr, String fileName){
		String file = "";
		for(String i : instr){
			file += i + "\n";
		}
		
		File f = new File(fileName);
		try {
			PrintWriter out = new PrintWriter(f);
			out.println(file);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String loadFile(String fileName){
		//System.out.println("Loading " + fileName);
		//Load file
		String file = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(FILES_LOCATION + fileName)));
			String line = "";
			while((line = reader.readLine())!=null){
				file += line + "\n";
			}
			reader.close();
		} catch (IOException e) {}
		
		//System.out.println("loaded file: " + file);
		
		//Search for include statement
		Pattern includePattern =Pattern.compile(INCLUDE_PATTERN);
		Matcher includeMatcher = includePattern.matcher( file );
		boolean b;
		while((b=includeMatcher.find())!=false){
			
			//System.out.println(b + " " + includeMatcher.start() + " " + includeMatcher.end());
			String left = file.substring(0, includeMatcher.start());
			String center = file.substring(includeMatcher.start(), includeMatcher.end());
			String right = file.substring(includeMatcher.end(), file.length());
			
			
			//Search for file name in include statement
			Pattern fileNamePattern = Pattern.compile(FILE_PATTERN);
			Matcher fileNameMatcher = fileNamePattern.matcher(center);
			fileNameMatcher.find();
			String nextFileName = center.substring(fileNameMatcher.start(), fileNameMatcher.end());
			nextFileName = nextFileName.substring(1, nextFileName.length()-1);
			
			//Load new file
			String nextFile = loadFile(nextFileName);
			
			file = new String(left + nextFile + right);
			
			includeMatcher = includePattern.matcher(file);
		}
		
		
		
		
		return file;
	}

}
