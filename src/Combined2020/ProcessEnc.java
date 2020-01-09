package Combined2020;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import ENC.EncStructure;

public class ProcessEnc {
	public Reports bigCheese; 
	public String inFile; 
	public String outFile; 
	private final static String NEWLINE = "\r\n"; 
	private File inputFile;
	private File outputFile;

	public ProcessEnc(Reports me) {
		this.bigCheese = me; 
		this.inFile = bigCheese.inputFilenameENC;
		this.outFile = bigCheese.outputFilenameENC; 
		this.inputFile = new File(inFile);
		this.outputFile = new File(outFile); 
		bigCheese.textArea.append(NEWLINE);
		bigCheese.textArea.append("File names set");
		bigCheese.textArea.append(NEWLINE);
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile)); 
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			bigCheese.textArea.append("InFile : " + inFile + NEWLINE); 
			bigCheese.textArea.append("OutFile: " + outFile + NEWLINE);
			
			String st;
			
			while ((st = br.readLine()) != null){
				String [] starray = st.split("\\t", -1);
				if(starray.length > 42) {
					EncStructure encstruct = new EncStructure(starray);
					/*** Each line is prepared for ouptut by the constructor method of encstruct ***/ 
				
					writer.write(encstruct.ARPNUM + "|");	
					
					writer.write(encstruct.ARBIRTH + "|");
					
					writer.write(encstruct.ARADMDT  + "|");
					
					writer.write(encstruct.ARPTYPE + "|");
					
					writer.write(encstruct.ARDISDT + "|");
					
					writer.write(encstruct.ARDISCOD + "|");
					
					writer.write(encstruct.ARMRNUM + "|");
					
					writer.write(encstruct.ARDIAG01 + "|");
					
					writer.write(encstruct.ARDIAG02 + "|");
					
					writer.write(encstruct.ARDIAG03 + "|");
					
					writer.write(encstruct.ARDIAG04 + "|");
					
					writer.write(encstruct.ARDIAG05 + "|");
					
					writer.write(encstruct.ARDIAG06 + "|");
					
					writer.write(encstruct.ARDIAG07 + "|");
					
					writer.write(encstruct.ARDIAG08 + "|");
					
					writer.write(encstruct.ARDIAG09 + "|");
					
					writer.write(encstruct.ARDIAG10 + "|");
					
					writer.write(encstruct.ARDIAG11 + "|");
					
					writer.write(encstruct.ARDIAG12 + "|");
					
					writer.write(encstruct.ARDIAG13 + "|");
					
					writer.write(encstruct.ARDIAG14 + "|");
					
					writer.write(encstruct.ARDIAG15 + "|");
					
					writer.write(encstruct.ARDIAG16 + "|");
					
					writer.write(encstruct.ARDIAG17 + "|");
					
					writer.write(encstruct.ARDIAG18 + "|");
					
					writer.write(encstruct.ARDIAG19 + "|");
					
					writer.write(encstruct.ARDIAG20 + "|");
					
					writer.write(encstruct.ARDIAG21 + "|");
					
					writer.write(encstruct.ARDIAG22 + "|");
					
					writer.write(encstruct.ARDIAG23 + "|");
					
					writer.write(encstruct.ARDIAG24 + "|");
					
					writer.write(encstruct.ARADMTM + "|");
					
					writer.write(encstruct.ARDISTM + "|");
					
					writer.write(encstruct.ARLASTNM + "|");	
					
					writer.write(encstruct.ARFIRSTNM + "|");
					
					writer.write(encstruct.ARPATZIP + "|");
					
					writer.write(encstruct.ERDOC1 + "|");
					
					writer.write(encstruct.ERDOCNM1 + "|");
					
					writer.write(encstruct.ERNPI + "|");
					
					writer.write(encstruct.MRPHY01 + "|");
					
					writer.write(encstruct.MRPHYNM01 + "|");
					
					writer.write(encstruct.PHSYNPI + "|");
					
					writer.write(encstruct.ARCAR1CD + "|");
					
					writer.write(encstruct.ARCAR2CD + "|");
					
					writer.write(encstruct.ARCAR3CD );
					writer.write(NEWLINE);
					bigCheese.textArea.append(NEWLINE);
					bigCheese.textArea.append("writing line that starts with " + encstruct.ARPNUM);
				}else {
					bigCheese.textArea.append("The line beginning with " + starray[0] + " | " + starray[1] + " was not processed because it was not greater than 43 fields " );
				}
			}//end while
			
			br.close();
			writer.close();
			bigCheese.textArea.append(NEWLINE);
			bigCheese.textArea.append("File writing completed");	
			
		}catch(Exception e) {
			bigCheese.textArea.append("ERROR : " + e);
			
		}
		
	}//end ProcessEnc constructor
	

}
