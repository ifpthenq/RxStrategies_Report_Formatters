package Combined2020;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class ProcessDrug {
	public String inFile = new String();
	public String outFile = new String(); 
	public String revFile = new String();
	public Reports me; 
	public File inputFile; 
	public File outputFile; 
	public File revcodeFile; 
	public List<Revkey> revList = new ArrayList<Revkey>(); 
	static String NEWLINE = "\r\n"; 

	public ProcessDrug(Reports me) {
		this.me = me; 
		this.inFile = me.inputFilenameDrug;
		this.outFile = me.outputFilenameDrug; 
		this.revFile = me.inputFilenameRev;
		this.inputFile = new File(inFile);
		this.outputFile = new File(outFile); 
		this.revcodeFile = new File(revFile); 
		try {
			/* Read in revcode file and build a list (revlist) */ 
			//create readers
			BufferedReader br2 = new BufferedReader(new FileReader(revcodeFile));
			String st2;
			//while there are more lines, 
			//    create a keypair and put it in array
			
			while ((st2 = br2.readLine()) != null) {
				System.out.println("Reading in line: " + st2);
				//parse line into sections
				
				String[] revLine = st2.split(",");
				
				if(revLine.length > 1) {
					Revkey revcodeKey = new Revkey(); 
					revcodeKey.IVNUM = revLine[0].trim(); 
					revcodeKey.IVREVCOD = revLine[1].trim();
					//put the revcode in the list
					revList.add(revcodeKey);
				}
				
			}
			br2.close();
			 /*
			  * Process Output File
			  */
				BufferedReader br = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)); 
				String st;
				while ((st = br.readLine()) != null) {
					 // System.out.println("DBG: The string i'm sending to process is \r\n" + st);
					    Process process = new Process(st, revList); 
					   
					    
					  //  System.out.println(process.rstring);
					    if(process.rstring != null) {
					    	if(!process.rstring.equals("delete")) {
					    		writer.write(process.rstring.trim());
					    		writer.newLine();
					    	}
					    }
				 }
				br.close();
				writer.close();
				me.textArea.append("File Writing is Complete");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("OOPs, couldn't open input file");
			me.textArea.append("ERROR: In DrugUtil. File not found " + e + NEWLINE);
			me.textArea.append("trying to process : " + this.inFile + NEWLINE + this.outFile + NEWLINE + this.revFile + NEWLINE);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			me.textArea.append("ERROR: in DrugUtil. IOException " + e + NEWLINE);
			e.printStackTrace();
		}
		
	}

}
