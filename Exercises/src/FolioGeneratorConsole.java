// @author RodrigoJimenezCorrea

import java.util.Scanner;

public class FolioGeneratorConsole {

	public static void main(String[] args) {
		
		FolioGenerator folioGenerator = new FolioGenerator();
		
		String folio;
		String DDD;
		
		String oldDB = "old_dataBase.txt";
		String newDB = "new_dataBase.txt";
		String stateCodes = "state_codes.txt";
	
		Scanner scan = new Scanner(System.in);
		String input;
	
		do {
		
			System.out.println("\n[FOLIO GENERATOR CONSOLE]");
			System.out.println("-----------------------");
			System.out.println("[O]ld | [N]ew | [E]xit");
			System.out.println("-----------------------");
			System.out.print("Option: ");
		
			input = scan.next();
			input = input.toUpperCase(); 

			
			switch(input) {
			
			case "O":
				
				folio = folioGenerator.generateFolio(oldDB);
				System.out.println("\nGenerated folio:\n"+folio);
				
				break;
				
			case "N":
				
				System.out.print("\nState code: ");
				DDD = scan.next();
												
				folio = folioGenerator.generateFolio(newDB, DDD, stateCodes);
				System.out.println("\nGenerated folio:\n"+folio);
				
				break;

			case "E": 
						
				System.out.println("\n> > > > > Bye > > > > >");
					
				break;
						
			default: 
						
				System.out.println("\nInvalid Option!");
				System.out.println("Please try again");
					
			}

		} while(input.compareTo("E")!=0);
			
		scan.close();
		
	}
	
}