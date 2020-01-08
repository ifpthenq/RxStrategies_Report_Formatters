package ENC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;

import javax.swing.JFrame;

public class Process1 {
	String infile;
	String outfile;
	Enc2019 frame; 
	File inputFile; 
	File outputFile; 
	private final static String NEWLINE = "\n"; 

	public Process1(String inputFileName, String outputFileName, Enc2019 frame) {
		this.infile = inputFileName; 
		this.outfile = outputFileName;
		this.frame = frame; 
		this.inputFile = new File(infile); 
		this.outputFile = new File(outfile);
		
		frame.textArea.append(NEWLINE);
		frame.textArea.append("input file name passed in " + inputFileName);
		frame.textArea.append(NEWLINE);
		frame.textArea.append("outputFile Name passed in " + outputFileName);
		
		
		frame.lblIndicator.setText("File is Processing");
		frame.frame.repaint();
		
		try {
			/***  Create the readers and writers */
			frame.textArea.append(NEWLINE);
			frame.textArea.append("input file name is " + inputFile.getName());
			frame.textArea.append(NEWLINE);
			frame.textArea.append("outputFile name is " + outputFile.getName());
			BufferedReader br = new BufferedReader(new FileReader(inputFile)); 
			frame.textArea.append(NEWLINE);
			frame.textArea.append("Created Buffered Reader");
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			frame.textArea.append(NEWLINE);
			frame.textArea.append("Created Buffered Writer");
			
			String st; 
			int count1 = 0; 
		
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
					frame.textArea.append(NEWLINE);
					frame.textArea.append("writing line that starts with " + encstruct.ARPNUM);
				}else {
					frame.textArea.append("The line beginning with " + starray[0] + " | " + starray[1] + " was not processed because it was not greater than 43 fields " );
				}
			}
			
		
			
			/*** Finally - close all the files */ 
			
			br.close();
			writer.close();
			frame.textArea.append(NEWLINE);
			frame.textArea.append("File writing completed");
		}
		catch(Exception e) {
			System.out.println("error " + e);
		}
	}

}
