
import java.io.IOException;
import java.util.Scanner;
public class Problem1 {

	public static void main(String[] args){
		
		boolean bError = true;
		System.out.println( " Type the price for one dollar in Japanese yen: ");
		Scanner sc = new Scanner(System.in); 
		
		do {
		  try {
			  
			sc = new Scanner(System.in); 
			
		double yen = sc.nextDouble();
		if (yen < 0) {
		     // this gets caught in the catch block
		     throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
		}  
		
		int a = 1;
        while (a != 0) {
       System.out.println( " Input 1 to convert from dollar to yen ");
       System.out.println(" Input 2 to convert from yen to dollar ");
       System.out.println(" Input 0 to exit"); 
       int choice = sc.nextInt();
       if (choice < 0) {
		     // this gets caught in the catch block
		     throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
		}  
       if ( choice!= 1 && choice != 2 && choice != 0) {
    	   System.out.println( " Please input a number from the option. ");
    	   System.out.println("--------------");
    	   continue;
       }
       System.out.println( " Do you want to change the conversion rate? Press 1 if you want to or else 0 to continue.");
       int c = sc.nextInt();
       if ( c!= 1 && c != 2 && c!= 0) {
    	   System.out.println( " Please input a number from the option ");
    	   System.out.println("--------------");
    	   continue;
       }
       if (c < 0) {
		     // this gets caught in the catch block
		     throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
		}  
       if ( c== 1) {
    	   System.out.println( " Type the new price for one dollar in Japanese yen: ");
    	   double yen_new= sc.nextDouble();
    	   yen = yen_new ; 
       }
       if( choice == 1) {
			System.out.println(" Input dollar amount that needs to be converted to yen ") ;
			double no = sc.nextDouble();
			double convert =  no * yen ;
			System.out.println( " Amount in yen is " + convert) ;
			System.out.println("");
		}
		if( choice == 2) {
			System.out.println(" Input yen amount that needs to be converted to dollar ") ;
			double no1 = sc.nextDouble();
			double convert1 =  no1 / yen ;
			System.out.println( " Amount in dollar is " + convert1) ;
			System.out.println("");
		}
		a= choice ; 
		bError = false;
	}
		}
		catch (Exception e)
		{
		System.out.println("Character Input and negative number input is not acceptable");
		sc.reset();
		}
		}while (bError);
	}
}
