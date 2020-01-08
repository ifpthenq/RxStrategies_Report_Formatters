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
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DrugUtil {

	private JFrame frame;
	File inputFile; 
	Boolean inputFileSet = false;
	String inputFileName;
	
	File inputFile2;
	Boolean inputFileSet2 = false;
	String inputFileName2 ; 
	
	File outputFile;
	String outputFileName;
	Boolean outputFileSet = false;
	Boolean fileComplete = false; 
	
	List<Revkey> revList = new ArrayList<Revkey>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrugUtil window = new DrugUtil();
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
	public DrugUtil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRxstrategiesDrugUtil = new JLabel("RxStrategies Drug Util Program");
		lblRxstrategiesDrugUtil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRxstrategiesDrugUtil.setBounds(21, 11, 351, 34);
		frame.getContentPane().add(lblRxstrategiesDrugUtil);
		
		JLabel lblVersion = new JLabel("Version 0.2.1");
		lblVersion.setBounds(21, 45, 107, 14);
		frame.getContentPane().add(lblVersion);
		
		JLabel lblLastUpdated = new JLabel("Last Updated 11/11/2019");
		lblLastUpdated.setBounds(21, 60, 158, 14);
		frame.getContentPane().add(lblLastUpdated);
		
		JLabel location1 = new JLabel("No File Selected");
		location1.setBounds(21, 116, 403, 14);
		frame.getContentPane().add(location1);
		
		JLabel location2 = new JLabel("No File Selected");
		location2.setBounds(21, 234, 403, 14);
		frame.getContentPane().add(location2);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser infc = new JFileChooser();
				//infc.setCurrentDirectory(new java.io.File("\\")); 
				infc.setDialogTitle("Choose DrugUtil File");
				infc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				infc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/DrugUtil"));
				if(infc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					inputFileSet = true;
					inputFileName = infc.getSelectedFile().toString();
					location1.setText(inputFileName);
					inputFile = infc.getSelectedFile();
					
				}
			}
		});
		btnSelect.setBounds(21, 85, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblSelectTheDrugutil = new JLabel("Select the DrugUtil file");
		lblSelectTheDrugutil.setBounds(120, 89, 304, 14);
		frame.getContentPane().add(lblSelectTheDrugutil);
		
		
		
		JButton btnSelect_1 = new JButton("Select");
		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(); 
				//fc.setCurrentDirectory(new java.io.File("\\")); 
				fc.setDialogTitle("Choose Save Location"); 
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/DrugUtil"));
					if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
					Date date = new Date();
					String strDate = dateFormat.format(date);
					
					outputFileSet = true; 
					outputFileName = fc.getSelectedFile().toString(); 
					outputFileName = fc.getSelectedFile().toString() + "\\2135_RCH_Charges" + strDate + ".txt"; 
					outputFile = new File(outputFileName); 
					location2.setText(outputFile.toString());;
				}
			}
			
		});
		btnSelect_1.setBounds(21, 200, 89, 23);
		frame.getContentPane().add(btnSelect_1);
		
		JLabel outputlbl = new JLabel("Select the Output file location");
		outputlbl.setBounds(120, 204, 314, 14);
		frame.getContentPane().add(outputlbl);
		
		JLabel completelbl = new JLabel("File Not Complete");
		completelbl.setForeground(Color.RED);
		completelbl.setBounds(21, 296, 134, 14);
		frame.getContentPane().add(completelbl);
		
		JLabel location3 = new JLabel("No File Selected");
		location3.setBounds(21, 175, 403, 14);
		frame.getContentPane().add(location3);
		
		JButton btnSelect_2 = new JButton("Select");
		btnSelect_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser infc2 = new JFileChooser(); 
				//infc2.setCurrentDirectory(new java.io.File("\\"));
				infc2.setDialogTitle("Choose RevCode File");
				infc2.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				infc2.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/DrugUtil"));
				if(infc2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					inputFileSet2 = true; 
					inputFileName2 = infc2.getSelectedFile().toString(); 
					location3.setText(inputFileName2);
					inputFile2= infc2.getSelectedFile();
					
				}
			}
		});
		btnSelect_2.setBounds(21, 141, 89, 23);
		frame.getContentPane().add(btnSelect_2);
		
		JButton btnBegin = new JButton("Start");
		btnBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					/**************************************
					 * Process IVNUMS/REVCODES into key pairs
					 */
					//create readers
					BufferedReader br2 = new BufferedReader(new FileReader(inputFile2));
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
					/**************************************
					 * Process output file
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
					writer.close();
					completelbl.setText("File Writing is Complete");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("OOPs, couldn't open input file");
				completelbl.setText("ERROR");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				completelbl.setText("ERROR");
				e.printStackTrace();
			} 
				
			}
		});
		btnBegin.setBounds(21, 262, 89, 23);
		frame.getContentPane().add(btnBegin);
		
		JLabel lblBeginFileCreation = new JLabel("Begin File Creation");
		lblBeginFileCreation.setBounds(120, 266, 134, 14);
		frame.getContentPane().add(lblBeginFileCreation);
		
		
		
		
		JLabel lblSelectTheRevcode = new JLabel("Select the RevCode file");
		lblSelectTheRevcode.setBounds(120, 145, 304, 14);
		frame.getContentPane().add(lblSelectTheRevcode);
		
		
		
		
	}
}
