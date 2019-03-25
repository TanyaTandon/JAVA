
//import all libraries needed
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class pro3copy {

	public static void main(String[] args) throws IOException, ParseException{


		//initialise three lists to store three values in the file	  
		ArrayList<Float> salary = new ArrayList<Float>();	    
		ArrayList<String> birth = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();

		int count = 0;
		File file = new File("employees.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));	
		String line = bufferedReader.readLine(); 

		while((line) != null) {
			count = count + 1;  
			salary.add(Float.valueOf(line.split(",")[2]));
			birth.add(line.split(",")[1]);
			name.add(line.split(",")[0]);

			line = bufferedReader.readLine(); 
		}


		System.out.println("Number of employees: " + (count)); 
		float temp = 0;
		String nam = "";
		String b = "" ;
		int i = 0 ; 
		
		for(i =0;i<salary.size();i++) {
			for(int j = 0;j<salary.size()-1;j++) {

				if(salary.get(j+1) > salary.get(j)) {
					temp = salary.get(j);
					salary.set(j,salary.get(j+1)) ;
					salary.set(j+1, temp);

					nam = name.get(j);
					name.set(j,name.get(j+1)) ;
					name.set(j+1, nam);

					b = birth.get(j);
					birth.set(j,birth.get(j+1)) ;
					birth.set(j+1, b);

				}
			}    
		}
		double sum = 0; 
		System.out.println("Highest is:  " + name.get(0));

		
		for( i =0; i < salary.size();i++)  {
			sum = sum + salary.get(i) ;
		}
		double avg = (sum/ count); 
		
		System.out.println("Average of employees is :  " + avg );
		int c = 0;
		
		for( i =0; i < salary.size();i++)  {
			if(salary.get(i) > avg) {
				c ++;   

			}

		}
		System.out.println("Number of employees above average: " + (c)); 
		
		// Print age
		age(birth, count);
		
		//Write File function 
		write_file(name, count);
	}
	
	public static void age(ArrayList<String> birth, int count) throws ParseException {
		SimpleDateFormat format1=new SimpleDateFormat("MM/dd/yyyy"); 

		ArrayList<Date> date1 = new ArrayList<Date>();

		Date dat1 = new Date(); 

		ArrayList<Long> diff = new ArrayList<Long>();
        int i ;
		for(  i =0; i < birth.size();i++) {
			Date dt= format1.parse(birth.get(i));
			date1.add(dt);

			diff.add(TimeUnit.MILLISECONDS.toMinutes(( (dat1.getTime() - dt.getTime() ))));


		}
		double s_age = 0; 
		for( i =0; i < birth.size();i++) {


			s_age = s_age  + ( diff.get(i)/(60 * 24 * 365 ));
		}

		System.out.println("Average of age is : " + (s_age/count));
		
	}

	private static void write_file(ArrayList<String> name, int count) throws IOException {
		File file1 = new File("temp.txt");
		String[] writeLines = new String[count];
		for (int i = 0; i < name.size(); i++) {
			writeLines[i] = name.get(i);
		}
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
		for (String l : writeLines) {
			bufferedWriter.write(l+"\n");
		}
		bufferedWriter.close();

	}
	

}



















