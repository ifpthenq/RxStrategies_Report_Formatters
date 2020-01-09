package Combined2020;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Process {
	public String st; 
	public String rstring; 
	public ArrayList<Revkey> revList = new ArrayList<Revkey>(); 
	private int revcode = 0; 

	
	
	public Process(String st, List<Revkey> revList) {
		this.st = st; 
		this.revList = (ArrayList<Revkey>) revList; 
		//test passed in array
		//for (Revkey key : revList) {
		//	System.out.println("IVNUM : " + key.IVNUM + " REVCODE : " + key.IVREVCOD);
		//}
		
		
		
		rstring = parse(st);
		

	}

	private String parse(String st2) {
		/*****************************
		 * Break the string up into an array
		 * with discrete sections
		 */
		
		//parse the string into an array
		//String [] array = st2.split(","); 
		String [] array = st.split("\\t", -1);
		System.out.println(array[0]);
		//check if its the header row
		if(array[0].trim().contains("ARPNUM")) {
			
			String returnThis = new String(); 
			returnThis = "ARPNUM|ARMRNUM|ARTYPE|ARORIGFC|IVNUM|IVDESC|IVCHGAMT|IVCHGQTY|IVCHGDTE|REVCODE "; 
			System.out.println("Header Written");
			return returnThis; 
		}else {
			//compare IVNUM array[4] to every number in the revList looking for a match
			for (Revkey key : revList) {
				if(key.IVNUM.trim().equals(array[4].trim())) {
			    //if it finds a match
					System.out.println(key.IVREVCOD + " is " + key.IVNUM);
					revcode = Integer.parseInt(key.IVREVCOD); 
					if(((revcode >= 250) && (revcode <= 259)) || ((revcode >= 630 && revcode <= 637))) {
					//and if that match is within the range spefied by RxStrategies
						String returnThis = new String(); 
						returnThis = array[0].trim() + "|"
								+ array[1].trim() + "|"
								+ array[2].trim() + "|"
								+ array[3].trim() + "|"
								+ array[4].trim() + "|"
								+ array[5].trim() + "|"
								+ array[6].trim() + "|"
								+ array[7].trim() + "|"
								+ array[8].trim() + "|"
								+ key.IVREVCOD.trim();
						return returnThis;
					}
					
				}
				//System.out.println("IVNUM : " + key.IVNUM + " REVCODE : " + key.IVREVCOD);
			}
			
			
		}
		//if its the header row, add the revcode header to the end and return
		return "delete";
	}
}
