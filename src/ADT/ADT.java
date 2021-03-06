package ADT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
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
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ADT {

	private JFrame frame;
	File inputFile; 
	String inputFileName;
	Boolean inputFileSet = false; 
	File outputFile;
	String outputFileName;
	Boolean outputFileSet = false;
	Boolean fileComplete = false; 
	String outputFilebyFile = new String("output.txt");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADT window = new ADT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ADT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Process CPSI ADT into Pipe Delim");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblVersion = new JLabel("Version 2.1");
		lblVersion.setBounds(10, 36, 282, 14);
		frame.getContentPane().add(lblVersion);
		
		JLabel lblLastUpdated = new JLabel("last updated: 11/11/19");
		lblLastUpdated.setBounds(10, 61, 258, 14);
		frame.getContentPane().add(lblLastUpdated);
		
		JLabel completelbl = new JLabel("Not Complete - DO NOT OPEN FILE");
		completelbl.setBounds(10, 213, 270, 14);
		frame.getContentPane().add(completelbl);
		
		/*
		 * JRadioButton rdbtnAdt = new JRadioButton("ADT");
		
			buttonGroup.add(rdbtnAdt);
			rdbtnAdt.setBounds(291, 183, 109, 23);
			frame.getContentPane().add(rdbtnAdt);
	
			JRadioButton rdbtnEncounter = new JRadioButton("Encounter");
			buttonGroup.add(rdbtnEncounter);
			rdbtnEncounter.setBounds(291, 209, 109, 23);
			frame.getContentPane().add(rdbtnEncounter);
			 */
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		
	
		JLabel location1 = new JLabel("No File Selected");
		location1.setBounds(10, 104, 414, 14);
		frame.getContentPane().add(location1);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser infc = new JFileChooser(); 
				infc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/ADT"));
				infc.setDialogTitle("Choose CPSI File");
				infc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				if(infc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					inputFileSet = true; 
					inputFileName = infc.getSelectedFile().toString(); 
					location1.setText(inputFileName);
					inputFile = infc.getSelectedFile();
				}
				
				
			}
		});
		btnSelect.setBounds(10, 79, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblSelectTheCsv = new JLabel("Select the TAB DELIMITED File to convert");
		lblSelectTheCsv.setBounds(109, 83, 258, 14);
		frame.getContentPane().add(lblSelectTheCsv);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					completelbl.setText("File Writing is Complete");
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("OOPs, couldn't open input file");
				completelbl.setText("ERROR");
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				completelbl.setText("ERROR");
				e1.printStackTrace();
			} 
				
				
				
			}
		});
		btnStart.setBounds(10, 183, 89, 23);
		frame.getContentPane().add(btnStart);
		
	
		
		JLabel location2 = new JLabel("No File Selected");
		location2.setBounds(10, 158, 414, 14);
		frame.getContentPane().add(location2);
		
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					outputFilebyFile = "2135_RCH_ADT" + strDate + ".txt";
				
			
				JFileChooser fc = new JFileChooser(); 
				fc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/ADT")); 
				fc.setDialogTitle("Choose Save Location"); 
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					
					outputFileSet = true; 
					outputFileName = fc.getSelectedFile().toString(); 
					//outputFileName = fc.getSelectedFile().toString() + "\\output.csv"; 
					outputFileName = fc.getSelectedFile().toString() + "\\" + outputFilebyFile;
					outputFile = new File(outputFileName); 
					location2.setText(outputFile.toString());;
				}
				
				
			}
		});
		btnNewButton.setBounds(10, 129, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
		
		JLabel lblSelectTheOutput = new JLabel("Select the output location");
		lblSelectTheOutput.setBounds(109, 133, 258, 14);
		frame.getContentPane().add(lblSelectTheOutput);
		
		
		
		JLabel lblNameFileFor = new JLabel("Name File For");
		lblNameFileFor.setBounds(291, 239, 109, 14);
		frame.getContentPane().add(lblNameFileFor);
	}
}
