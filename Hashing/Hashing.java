
import java.io.*;
import java.util.*;

public class homework {

	private static Scanner sc;

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> names = new ArrayList<String>();
		File file = new File("input.txt");
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));	
		String line = bufferedReader.readLine(); 
		names.add(line);
		while((line) != null) {
			line = bufferedReader.readLine(); 			
			names.add(line);
		}
		names.remove(names.size() - 1);
		int fc = 0; 
		
		sc = new Scanner(System.in);
		boolean br= true; 
		do {
			try {
			System.out.println("Pick an option"); 
			System.out.println(" 1: Array list size 100 ");
			System.out.println(" 2: Array list size 200 ");
			int choice = sc.nextInt(); 
				if(choice == 1)
				{
				fc = 100;
				}
				if(choice == 2)
				{
				fc = 200;
				}
				if( choice < 0 || ( choice!= 1 && choice != 2))
				{
					System.out.println( "Make the choice between the 2 options only."); 	
					continue; 
				}
				
			br = false; 
			}
			
			catch(InputMismatchException e )
			{
			System.out.println( "Make the choice between the 2 options only."); 
			sc.next();
			}
	} while(br); 
	
	
		int colcount1 = 0 ; 
		int colcount2 = 0 ; 
		int colcount3 = 0;
		String on = " "; 
		String nameToHash; 
		int value = 0 ;
		
		int value1 = 0 ; 
		
		ArrayList<String> names_hash1 = new ArrayList<String>();
		ArrayList<String> names_hash2 = new ArrayList<String>();
		ArrayList<String> names_hash3 = new ArrayList<String>();
		
		// Solve Hash function 1 
		for(int i = 0; i<fc; i++) {
			names_hash1.add(i, "");
			names_hash2.add(i, "");
			names_hash3.add(i, "");
		}
		
		for(int i = 0; i< names.size(); i++) {
           
			value= toAscii(names.get(i)); 
			value = value % fc;
			
			
			
			if(names_hash1.get(value)!="") {
				on = names_hash1.get(value);
				nameToHash = names.get(i) + ", " + on;
				colcount1++;
				
				
			}
			else {
				nameToHash = names.get(i);
				
			}
			
			names_hash1.set(value, nameToHash);
			
			
			
			// same for hash2
			
		
			value1=  Math.abs((names.get(i).hashCode())% fc); 
			
			
			if(names_hash2.get(value1)!="") {
				on = names_hash2.get(value1);
				nameToHash = names.get(i) + ", " + on;
				colcount2++;
				
				
			}
			else {
				nameToHash = names.get(i);
				
			}
			
			names_hash2.set(value1, nameToHash);

		
		
		// same for hash3
		int value3 = 0; 
		 
		value3= toAscii2(names.get(i)) * 3  ; 
		value3 = value3 % fc;
					
					if(names_hash3.get(value3)!="") {
						on = names_hash3.get(value1);
						nameToHash = names.get(i) + ", " + on;
						colcount3++;
						
						
					}
					else {
						nameToHash = names.get(i);
						
					}
					
					names_hash3.set(value3, nameToHash);

				}
		
		
		
	
		
			for( int k = 0 ; k< fc ; k ++) 
			{
				
				if( names_hash1.get(k) == "") {
					names_hash1.set(k, " EMPTY LINE…") ;
					
					
				}
				 if( names_hash2.get(k) == "") {
					names_hash2.set(k, " EMPTY LINE…") ;
					
				} 
			} 
			
			//Executes write files
			 
			write_file(names_hash1, names_hash2) ; 
			 write_file2( colcount1, colcount2, colcount3); 
			
	}
	// ASCII function  
	 public static int toAscii(String s){
			int i;
			char word[] = s.toCharArray();
			int sum = 0;
			int charVal;

			for (i=0; i < word.length; ++i) {
				charVal = (int) word[i] ;
				sum += charVal;
			} 
			return(sum);
			
		}
	 
	// ASCII function  
		 public static int toAscii2(String s){
				int i;
				char word[] = s.toCharArray();
				int sum = 0;
				int charVal;
                
				for (i=0; i < word.length; ++i) {
					charVal = (int) word[i]/ 2 ;
					sum += charVal;
				} 
				return(sum);
				
			}
	 
	//Writing Function for Output 1 and Output 2 
	 public static void write_file(List<String> names_hash1, List<String> names_hash2) throws IOException {
			File file1 = new File("Output1.txt");
			File file2 = new File("Output2.txt");
			int count1 = names_hash1.size(); 
			
			String[] writeLines1 = new String[count1];
			String[] writeLines2 = new String[count1];
			for (int i = 0; i < count1; i++) {
				writeLines1[i] =  i + " : " + names_hash1.get(i).toString(); 
				writeLines2[i] =  i + " : " + names_hash2.get(i).toString(); 
			}
			BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file1));
			BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
			for (String l : writeLines1) {
				bufferedWriter1.write(l+"\n");
			}
			
			for (String l : writeLines2) {
				bufferedWriter2.write(l+"\n");
			}
			bufferedWriter1.close();
			bufferedWriter2.close();
		}
	
	 //Writing Function for metric
		public static void write_file2(int hash1, int hash2, int hash3) throws IOException {
			
			FileWriter writer = new FileWriter("Result.txt");
			writer.write("The 3 hash functions are measured by number of collisions \r\n");
			writer.write("ASCII Collisions: " + hash1 +"\r\n");
			writer.write("Java Collisions: "  + hash2 +"\r\n");
			writer.write("Custom Collisions: " + hash3 +"\r\n");
			writer.close();
		}

}


