import java.text.ParseException;
import java.util.Date;

public abstract class Appointment {
int dayNum ; 
int monthNum1 ;
 int yearNum1 ; 
 int monthNum2 ;
 int yearNum2 ;
String desc ; 
Date Date1;
Date Date2; 
	
	public Appointment ( String des2, Date d1, Date d2){
		desc = des2 ;
		Date1 = d1;
		Date2 =  d2; 
		 
	}

	@Override
	public String toString() {
		return desc + ": " + Date1 + ": " + Date2;
	}
abstract String getDesc() ;
abstract boolean occursOn( int day, int month, int year) throws ParseException ; 

abstract String appointment_type (); 
}

