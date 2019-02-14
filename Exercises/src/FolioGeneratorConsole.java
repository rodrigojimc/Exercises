// @author RodrigoJimenezCorrea

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
				
						folio = FolioGenerator.folioGen(oldDB);
						System.out.println("\nGenerated folio:\n"+folio);
				
						break;
				
					case "N":
				
						System.out.print("\nState code: ");
						DDD = scan.next();
												
						folio = FolioGenerator.folioGen(newDB, DDD, stateCodes);
						System.out.println("\nGenerated folio:\n"+folio);

						break;
					}
		
			}while(!validOption);

		} while(input.compareTo("E")!=0);
			
		scan.close();
		
	}
	
}