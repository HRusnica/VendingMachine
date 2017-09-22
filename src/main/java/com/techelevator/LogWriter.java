package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class LogWriter {

	public void logWriterMeth(String input){
		try (PrintWriter logPrintWriter = new PrintWriter(new FileOutputStream( new File("./Log.txt"), true))){
			Date timeStamp = new Date();
			logPrintWriter.println(timeStamp + "  " + input);	
		}catch (FileNotFoundException e) {
			System.out.println("The log file is not available");
			System.exit(2);
		}
	}
	
}
