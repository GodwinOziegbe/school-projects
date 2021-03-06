package application;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExportFileWriter {
	private static ExportFileWriter instance= new ExportFileWriter();

	public ExportFileWriter() {
		
	}

	public static ExportFileWriter getInstance() {
		return instance;
	}
	
public void writeExport(ArrayList<Sales>reportPrintList) {
	String filePath="C:\\Users\\dwino\\eclipse-workspace\\systemArchitectureInlämingsUppgift\\src\\application\\exportFile.txt";
	Scanner input = new Scanner(System.in);
	   try {
		   FileWriter fw=new FileWriter(filePath);
		   fw.write("Sales Record\n ");
		   fw.write("---------------- \n");
		  for(Sales value:reportPrintList) {
			  
		     fw.write("Sales Id: "+value.getSalesId() +"\n");
		     fw.write("Customer Id:"+value.getCustomerId() +"\n");
		     fw.write("Product's Name: "+value.getProductName() +"\n");
		     fw.write("Date Of Sales:"+value.getDateOfSales() +"\n");
		     fw.close();
		  } 
	   } catch(Exception e) {System.out.println(e);}
	     System.out.println("Success...");
 input.close();
	}

}

