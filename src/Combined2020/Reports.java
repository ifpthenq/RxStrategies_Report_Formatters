package Combined2020;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Reports {

	private JFrame frame;
	public Reports me = this; 
    public JTextArea textArea; 
    private JTextField textField;
    public String filenameTag = new String(); 
    public String baseFileLocation = new String(); 
	
	/* decalre Encounter variables */ 
	public String inputFilenameENC = new String("enc.txt"); 
	public File inputFileENC; 
    public String outputFilenameENC = new String();
    public Boolean inFileEncSet = false; 
    public Boolean fileCompleteEnc = false; 
    public JScrollPane scrollPane; 

    
    /* declare Drug variables */
    public String inputFilenameDrug = new String("drug.txt");
    public File inputFileDrug; 
    public String outputFilenameDrug = new String(); 
    public Boolean outFileDrugSet = false;
    public Boolean fileCompleteDrug = false; 
    public String inputFilenameRev = new String("cosswalk.csv"); 
    
    /* declare ADT variables */ 
    public String inputFilenameADT = new String ("adt.txt"); 
    public File inputFileADT; 
    public String outputFilenameADT = new String(); 
    
    public static String NEWLINE = "\r\n"; 
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports window = new Reports();
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
	public Reports() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DateAsString gdate = new DateAsString();
		filenameTag = gdate.getDate; 
		
		frame = new JFrame();
		frame.setBounds(100, 100, 927, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("<HTML><h3>RxStrategies Combined Report Formatter </h3><br>\r\nVersion 1.0<br>\r\nlast updated: 1.8.2020\r\n</html>\r\n");
		lblTitle.setBounds(32, 0, 784, 96);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblInstructions = new JLabel("<html><b>Instructions</b><br>\r\n<ul><li>Save CPSI ADT report as adt.txt (tab delimited)</li>\r\n<li>Save CPSI Encounters report as enc.txt (tab delimited)</li>\r\n<li>Save CPSI Drug Util report as drug.txt (tab delimited)</li>\r\n<li>Save RevCode Crosswalk as crosswalk.csv (comma delimited </li><ul>");
		lblInstructions.setBounds(32, 101, 753, 122);
		frame.getContentPane().add(lblInstructions);
		
		JLabel lblSelect = new JLabel("Select input and output folder");
		lblSelect.setBounds(32, 197, 425, 14);
		frame.getContentPane().add(lblSelect);
		
		JLabel lblLocation = new JLabel("No location selected");
		lblLocation.setBounds(152, 226, 228, 14);
		frame.getContentPane().add(lblLocation);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser infc = new JFileChooser(); 
				infc.setCurrentDirectory(new java.io.File("C:/Reports/RxStrategies"));
				infc.setDialogTitle("Choose CPSI File");
				infc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				if(infc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					inFileEncSet = true; 
					baseFileLocation = infc.getSelectedFile().toString(); 
					lblLocation.setText(baseFileLocation);
					/* Set ENC Filenames */ 
					inputFilenameENC = baseFileLocation + "\\"  + "enc.txt";
					//inputFile = infc.getSelectedFile();
					outputFilenameENC = "2135_RCH_Encounter_" + textField.getText().trim() + ".txt"; 
					outputFilenameENC = infc.getSelectedFile().toString() + "\\" + outputFilenameENC; 
					/* Set Drug Filenames */ 
					inputFilenameDrug = baseFileLocation + "\\" + "drug.txt"; 
					outputFilenameDrug = "2135_RCH_Charges_" + textField.getText().trim() + ".txt"; 
					outputFilenameDrug = infc.getSelectedFile().toString() + "\\" + outputFilenameDrug; 
					inputFilenameRev = baseFileLocation + "\\" + "crosswalk.csv"; 
					System.out.println("revcode file is " + inputFilenameRev); 
					/* Set ADT Filename */ 
					inputFilenameADT = baseFileLocation + "\\" + "adt.txt"; 
					outputFilenameADT = "2135_RCH_ADT_" + textField.getText().trim() + ".txt"; 
					outputFilenameADT = infc.getSelectedFile().toString() + "\\" + outputFilenameADT; 
					
					
				}
			}
		});
		btnSelect.setBounds(32, 222, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Process Enc File */
				/*
				 * 
				 * 
				 * 
				 */
				ProcessEnc enc = new ProcessEnc(me); 
				textArea.append("ENC file processing complete" + NEWLINE);
				
				
				/*Process ADT File */ 
				/*
				 * 
				 * 
				 * 
				 */
				ProcessDrug drug = new ProcessDrug(me); 
				textArea.append("Drug file processing complete" + NEWLINE);
				
				/*Process Drug File */ 
				/*
				 * 
				 * 
				 * 
				 */
				ProcessADT adt = new ProcessADT(me); 
				textArea.append("ADT file processing complete" + NEWLINE);
				
			}
		});
		btnStart.setBounds(32, 268, 89, 23);
		frame.getContentPane().add(btnStart);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 322, 753, 182);
		frame.getContentPane().add(scrollPane);
		
		
		/* JTextArea txtrTextarea = new JTextArea();
		txtrTextarea.setText("textArea");
		txtrTextarea.setBounds(32, 322, 753, 182);
		frame.getContentPane().add(txtrTextarea);
		*/ 
		
		textArea = new JTextArea(); 
		scrollPane.setViewportView(textArea);
		
		JLabel lblDatelabel = new JLabel("Enter date label (i.e. 01012020)");
		lblDatelabel.setBounds(453, 58, 363, 14);
		frame.getContentPane().add(lblDatelabel);
		
		/*filenameTag*/
		textField = new JTextField();
		textField.setBounds(453, 76, 148, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(filenameTag);
	}
}
