package ENC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Enc2019 {

	public JFrame frame;
	private JTextField textFieldFileName;
	public File inputFile; 
	String inputFileName;
	Boolean inputFileSet = false; 
	public File outputFile;
	String outputFileName;
	Boolean outputFileSet = false;
	Boolean fileComplete = false; 
	String outputFilebyFile = new String("output.txt");
	public JLabel lblIndicator; 
	Enc2019 me = this; 
	public JScrollPane scrollPane; 
	public JTextArea textArea; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enc2019 window = new Enc2019();
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
	public Enc2019() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblProgramTitle = new JLabel("RxStrategies Encounter Report");
		lblProgramTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProgramTitle.setBounds(10, 11, 269, 29);
		frame.getContentPane().add(lblProgramTitle);
		
		JLabel lblInfo = new JLabel("<html>This report takes the zACH03 report, adds NPIs, and prints it as a line delimited file.  <br> File must be saved in a TAB delimited format </html>");
		lblInfo.setBounds(10, 68, 567, 43);
		frame.getContentPane().add(lblInfo);
		
		JLabel lblVersion = new JLabel("Version 2.1 - last revised 6/4/2019");
		lblVersion.setBounds(10, 43, 269, 14);
		frame.getContentPane().add(lblVersion);
		
		JLabel location1 = new JLabel("Select the zACH03 report");
		location1.setBounds(109, 137, 454, 14);
		frame.getContentPane().add(location1);
		
		
		JButton btnSelectFile = new JButton("Select File");
		btnSelectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser infc = new JFileChooser(); 
				infc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/Encounter"));
				infc.setDialogTitle("Choose CPSI File");
				infc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				if(infc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					inputFileSet = true; 
					inputFileName = infc.getSelectedFile().toString(); 
					location1.setText(inputFileName);
					//inputFile = infc.getSelectedFile();
				}
				
			}
		});
		btnSelectFile.setBounds(10, 133, 89, 23);
		frame.getContentPane().add(btnSelectFile);
		

		textFieldFileName = new JTextField();
		textFieldFileName.setBounds(10, 165, 89, 20);
		frame.getContentPane().add(textFieldFileName);
		textFieldFileName.setColumns(10);
		
		JLabel lblEnterTheFilename = new JLabel("Enter the filename identifier (i.e. 06042019 for Jun 6 2019)");
		lblEnterTheFilename.setBounds(109, 168, 306, 14);
		frame.getContentPane().add(lblEnterTheFilename);
		
		lblIndicator = new JLabel("");
		lblIndicator.setBounds(135, 258, 340, 14);
		frame.getContentPane().add(lblIndicator);
		
		
		JLabel location2 = new JLabel("Set the output location");
		location2.setBounds(135, 200, 442, 14);
		frame.getContentPane().add(location2);
		
		JButton btnOutputLocation = new JButton("Output Location");
		btnOutputLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputFileName = "2135_RCH_Encounter_" + textFieldFileName.getText() + ".txt";
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies/Encounter"));
				fc.setDialogTitle("Choose Save Location");
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					outputFileSet = true; 
					outputFileName = fc.getSelectedFile().toString() + "\\" + outputFileName;
					location2.setText(outputFileName);
					
				}
			}
		});
		btnOutputLocation.setBounds(10, 196, 115, 23);
		frame.getContentPane().add(btnOutputLocation);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Process1 process = new Process1(inputFileName, outputFileName, me); 
			}
		});
		btnStart.setBounds(10, 258, 89, 23);
		frame.getContentPane().add(btnStart);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 584, 103);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		

		
	}
}
