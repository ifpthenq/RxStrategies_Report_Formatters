package Combined2020;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;

public class DateAsString {
    public String getDate = new String(); 
    
    public DateAsString(){
    	Date date = Calendar.getInstance().getTime();
    	DateFormat dateFormat = new SimpleDateFormat("MMddyyyy"); 
    	String strDate = dateFormat.format(date); 
    	this.getDate = strDate; 
    	//System.out.println("the date is " + strDate);
    }
}
