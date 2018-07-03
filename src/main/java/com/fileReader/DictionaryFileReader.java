package com.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DictionaryFileReader {
	File f;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new
		        InputStreamReader(System.in));
		        System.out.println("Enter the path of the dictionary file in the classpath");
		         String sPath = br.readLine();
		        
		        DictionaryFileReader dfr = new DictionaryFileReader();
		        boolean isFileExist = dfr.doesFileExist(sPath);
		        if(!isFileExist) {
		        	throw new FileNotFoundException("No file exist at the path entered");
		        }else {
		        	System.out.printf("File " + sPath+" exists");
		        	dfr.readFile(sPath);
		        }
		        //Parsing and printing contents of file
		        

	}

	public boolean doesFileExist(String path) {
		f = new File(path);
		
		if(f.exists()) {
		
		return true;
		}else {
			return false;
		}
		
	}

	public void readFile(String path)  {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(path));
			String sCurrentLine;
			String sWord;
			String []meanings;
			System.out.println("\nPrintiing words and meanings from " +path+"...");
			while ((sCurrentLine = br.readLine()) != null) 
			{
				sWord = sCurrentLine.split("-")[0];
				meanings = sCurrentLine.split("-")[1].split(",");
				System.out.println("\n"+sWord);
				for(String s:meanings) {
					System.out.println(s);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
