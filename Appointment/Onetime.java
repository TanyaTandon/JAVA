import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Onetime extends Appointment {
	

	public Onetime( String des, Date d1, Date d2)
	{
		super(des,d1,d2) ; 
	}
   public String getDesc() {
	   return desc ; 
 
   }
   
   public String appointment_type() {
	  return( "One time") ; 
   }
   boolean occursOn(int day, int month, int year) throws ParseException{
	   SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
	   Date d4= myFormat.parse(Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year));
       if(Date1.equals(d4))
       {
           return true;
       }
       else 
       { 
       return false;
       } 
   }      
   }
   


