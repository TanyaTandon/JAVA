import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
	
	public class test {
		static Date d1 = null; 
		static Date d2 = null; 
		static String sd = null ; 
		static String des = null;
		private static Scanner sc; 
	
		public static void main(String[] args) throws ParseException, IOException {
			sc = new Scanner(System.in);

			ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		   boolean f = true; 
		   boolean te = true; 
		while(f) {
			   do {
			       try {
					   System.out.println( "Pick a option from menu");
					   System.out.println("1: Add an appointment ") ; 
					   System.out.println("2: Load saved appointments in a text file"); 
					   System.out.println("3: Find an appointment.  "); 
					   System.out.println( "4: To exit. "); 
					   int choice = sc.nextInt(); 
							   if( choice == 1)
							   {
							   add(appointments);
							   
							   }
							   if( choice == 2)
							   {
                                write_file(appointments,appointments.size() ); 
                                System.out.println(appointments);
							   }
								if (choice ==3 )
								{
							   check(appointments) ;
							   
								}
								if( choice ==4)
								{
									System.out.println( "Exit"); 
									
									f = false; 
								}
								if( choice <0 )
								{
								System.out.println("Please choose another choice"); 
								}
			      te = false; 
			       }
					 catch(InputMismatchException e)
					  {
						System.out.println( "Please choose another choice");
						sc.next();
						
					  } 
					
			} while(te);
		}	
		}
				
	public static void add( List <Appointment> appointments) 
	{
		boolean berror = true ; 
		do {
			try 
				{
				SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
				myFormat.setLenient(false);
		
				System.out.println( "1: To make one time appointment");
				System.out.println( "2: To make monthly appointment");
				System.out.println( "3: To make daily appointment");
				System.out.println( "4: Stop inputting"); 
			    int t = sc.nextInt(); 
				
			    if ( t==1) {
				System.out.println(" Input description. ");
				  des = sc.next();
				
				 System.out.println( "Input one-time date in MM/DD/YYYY format only");
					 sd = sc.next();			 
					d1= myFormat.parse(sd);
				Appointment ap1 = new Onetime(des, d1, d1);
				appointments.add(ap1); 
				
				}
				else if( t==2) {
					System.out.println(" Input description. ");
					  des = sc.next();
					  System.out.println(" Input day ");  
					  int day = sc.nextInt() ; 
					  System.out.println(" Input starting month"); 
					  int month1 = sc.nextInt() ; 
					  System.out.println(" Input starting year");
					  int year1 = sc.nextInt() ; 
					  System.out.println(" Input ending month");
					  int month2 = sc.nextInt() ;
					  System.out.println(" Input ending year");
					  int year2 = sc.nextInt() ; 
					  d1= myFormat.parse(Integer.toString(month1) + "/" + Integer.toString(day) + "/" + Integer.toString(year1));
					  d2= myFormat.parse(Integer.toString(month2) + "/" + Integer.toString(day) + "/" + Integer.toString(year2));
					  if (d1.compareTo(d2)>= 0 )
						 {
							System.out.println("End date should be after start date");
						}
						else {
					  Appointment ap2 = new Monthly(des, d1, d2);
					  appointments.add(ap2); 
						}
				}
				else if ( t==3) {
					System.out.println(" Input description. ");
					des = sc.next();
					System.out.println( "Input starting date in MM/DD/YYYY format only.");
					sd = sc.next();
					d1= myFormat.parse(sd);
					System.out.println( "Input ening date in MM/DD/YYYY format only.");
					String ed = sc.next();
					d2= myFormat.parse(ed);
					if (d1.compareTo(d2)>= 0 )
					 {
						System.out.println("End date should be after start date");
					}
					else {
					Appointment ap3 = new Daily(des, d1, d2);
					appointments.add(ap3); 
					}
					}
				berror= false; 
			}
			
			catch (ParseException e) 
			{
				System.out.println("Invalid date");
			}
	} while(berror);
	}
		
	public static void check(List <Appointment> appointments) throws ParseException	{
		
		  System.out.println(" Input day ");  
		  int day = sc.nextInt() ; 
		  System.out.println(" Input month"); 
		  int month = sc.nextInt() ; 
		  System.out.println(" Input year");
		  int year = sc.nextInt() ; 
		  int c = 0 ; 
		  SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
		  try {
		  Date dtest= myFormat.parse(Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year));
		  }
		  catch( Exception e)
		  {
		  System.out.println( "Try a valid date. "); 
		  }
		  
		  
		  for( int i = 0; i <appointments.size(); i ++)
		  {
			  Appointment appointment = appointments.get(i);
			  if( appointment.occursOn(day, month, year))
			  {
				  System.out.println(appointment.desc);
				  c = c+ 1;
			  }
			  if (c ==0 )
				  
			  {
				  System.out.println("No appointments found");
			  }
			  
		  }
		  	
	}
	public static void write_file(List <Appointment> appointments, int count) throws IOException {
		File file1 = new File("temp.txt");
		String[] writeLines = new String[count];
		for (int i = 0; i < appointments.size(); i++) {
			writeLines[i] = appointments.get(i).toString(); 
		}
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
		for (String l : writeLines) {
			bufferedWriter.write(l+"\n");
		}
		bufferedWriter.close();
	}
	
	}
	
		
	
	
