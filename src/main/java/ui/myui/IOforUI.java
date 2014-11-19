package ui.myui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOforUI {
	
	private BufferedReader br;

	public void writeTo(String str, String file){
		try {
			File filename=new File(file);
			
			if (!filename.exists()) { 
				filename.createNewFile();}
			
			FileWriter fw=new FileWriter(filename);
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readFrom(String file){
		File filename=new File(file);
		String str = null;		
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);
			try {
				
				str = br.readLine();		
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		return str;
	}
	
	public int getX(){
		
		String[] str = readFrom("ui/data/location.txt").split(";");
		return Integer.parseInt(str[0]);
	}
	
	public int getY(){
		
		String[] str = readFrom("ui/data/location.txt").split(";");
		return Integer.parseInt(str[1]);
	}
}
