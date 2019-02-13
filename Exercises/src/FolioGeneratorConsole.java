// @author RodrigoJimenezCorrea

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FolioGeneratorConsole {

	public static void main(String[] args) {
		
		String folio;
		String DDD;
		
		String oldDB = "old_dataBase.txt";
		String newDB = "new_dataBase.txt";
		String stateCodes = "state_codes.txt";
	
		Scanner scan = new Scanner(System.in);
		String input;
	
		String[] options = {"O","N","E"};
		boolean validOption;
	
			do {
		
				do {
		
					System.out.println("\n[FOLIO GENERATOR CONSOLE]");
					System.out.println("-----------------------");
					System.out.println("[O]ld | [N]ew | [E]xit");
					System.out.println("-----------------------");
					System.out.print("Option: ");
		
					input = scan.next();
					validOption = Arrays.stream(options).anyMatch(input:: equals);
		
					if (!validOption) {
			
						System.out.println("\nInvalid Option!");
						System.out.println("Please try again");
					}
			
					switch(input) {
			
					case "O":
				
						do { folio = FolioGenerator.folioGen(); } while (FolioGenerator.folioInDB(folio, oldDB));
				
						FolioGenerator.addFolioToDB(folio, oldDB);
						System.out.println("\nGenerated folio:\n"+folio);
				
						break;
				
					case "N":
				
						System.out.print("\nState code: ");
						DDD = scan.next();
						
						String line = null;
						boolean found = false;
						
						try{
							
							FileReader fileReader = new FileReader(stateCodes);
							BufferedReader bufferedReader =  new BufferedReader(fileReader);
							
							do{
								line = bufferedReader.readLine();
								
								if (line!=null && DDD.compareTo(line) == 0) { found = true; }
								
							} while(!found && line != null);
							
							bufferedReader.close(); 
						}
						
						catch(IOException ex) {
							System.out.println( "Error reading file '"+stateCodes+"'");
						}
						
						if(found) {
							
							do { folio = FolioGenerator.folioGen(DDD); } while (FolioGenerator.folioInDB(folio, newDB));
							
							FolioGenerator.addFolioToDB(folio, newDB);
							System.out.println("\nGenerated folio:\n"+folio);
						}
						
						else {System.out.println( "Error state code '"+DDD+"' not found"); }
				
						break;
					}
		
			}while(!validOption);

		} while(input.compareTo("E")!=0);
	}
}