package Combined2020;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessADT {
	public String inFile; 
	public String outFile; 
	public File inputFile; 
	public File outputFile; 
	public Reports me; 

	public ProcessADT(Reports me) {
		this.me = me; 
		this.inFile = me.inputFilenameADT; 
		this.outFile = me.outputFilenameADT; 
		this.inputFile = new File(inFile); 
		this.outputFile = new File(outFile); 
		
		try {
			
			/**************************************
			 * Process output file
			 */
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)); 
			String st;
			while ((st = br.readLine()) != null) {
				//String [] array = st.split(","); 
				String [] array = st.split("\\t", -1);
				String rstring = new String(); 
				int arrayLength = array.length; 
				int pipes = arrayLength-1; 
				for(int a=0; a<pipes; a++) {
					rstring = rstring + array[a] + "|"; 
				}
				rstring = rstring + array[pipes] ;
				System.out.println(rstring);  
				writer.write(rstring.trim());
				writer.newLine();
				    	
				  
				  }
			writer.close();
			me.textArea.append("File Writing is Complete");
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		System.out.println("OOPs, couldn't open input file");
		me.textArea.append("ERROR: in ADT. Coupdn't find file");
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		me.textArea.append("ERROR: in ADT");
		e1.printStackTrace();
	} 
	}

}
