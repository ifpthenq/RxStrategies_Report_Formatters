package Combined2020;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Reports {

	private JFrame frame;

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
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(32, 222, 89, 23);
		frame.getContentPane().add(btnSelect);
		
		JLabel lblLocation = new JLabel("No location selected");
		lblLocation.setBounds(152, 226, 228, 14);
		frame.getContentPane().add(lblLocation);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(32, 268, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JTextArea txtrTextarea = new JTextArea();
		txtrTextarea.setText("textArea");
		txtrTextarea.setBounds(32, 322, 753, 182);
		frame.getContentPane().add(txtrTextarea);
	}
}
