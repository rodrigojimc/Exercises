// @author RodrigoJimenezCorrea

import java.util.Random;
import java.util.Scanner;

class Mouse{
	
	boolean location[][] = new boolean[5][5];
	Random random = new Random();
	
	Mouse() { 
		
		this.location[random.nextInt(5)][random.nextInt(5)] = true; 
		
	}
	
}

class Cat{
	
	public boolean catchMouse (Mouse mouse, int x, int y) { return mouse.location[x][y]; }
	
}

public class CatVsMouse {

	public static int play(){
	
		int win = 0;
		int x = 0;
		int y = 0;
		
		boolean tries[][] = new boolean[5][5];
		
		Scanner scan = new Scanner(System.in);
		String guess;
		
		Mouse mouse = new Mouse();
		Cat cat = new Cat();
		
		System.out.println("\n<Game Starts!>");
		
		for (int i=0; i<5; i++) {
			
			do {
				System.out.println("\nTries left: "+(5-i));
				System.out.print("Coordinates: ");
				
				guess = scan.next();
				
				if (!guess.matches("[12345],[12345]")) {
					
					System.out.println("\nInvalid format!");
					System.out.println("Input must be x,y");
					System.out.println("both from 1 to 5");
					System.out.println("Please try again");
					
				}
				
				else {
					
					x = Character.getNumericValue(guess.charAt(0))-1;
					y = Character.getNumericValue(guess.charAt(2))-1;
					
					if (tries[x][y]) {
						
						System.out.println("\nAlready tried!");
						System.out.println("Look somwhere else");
						
					}
				}
				
			} while (!guess.matches("[12345],[12345]") || tries[x][y]);
			
			System.out.print("\nZarp!... ");
			
			tries[x][y] = true;
			
			if (cat.catchMouse(mouse,x,y)) {
				
				System.out.println("Caught!");
				
				win=1;
				break;
			}
			
			else {
				
				System.out.println("Nope!");
				
			}
			
		}
		
		if (win==1) { System.out.println("\nVICTORY! :D"); } 
		else { System.out.println("\nDEFEAT :c"); };
		
		scan.close();
		
		return win;
		
	}
	
	public static void main(String[] args) {
		
		int timesPlayed = 0;
		int timesWon = 0;
		
		Scanner scan = new Scanner(System.in);
		String option;
		
		System.out.println("\n[CAT VS MOUSE]");
		System.out.println(" - The Game - ");
		
		do {
			
			System.out.println("\n#    MENU    #");
			System.out.println("---------------");
			System.out.println("[P]lay | [E]xit");
			System.out.println("---------------");
			System.out.print("Option: ");
			
			option = scan.next();
			
			if (option.compareTo("P")!=0 && option.compareTo("E")!=0) {
				
				System.out.println("\nInvalid Option!");
				System.out.println("Please try again");
				
			}

			switch (option) {
			
			case "P":
				
				timesPlayed++;
				timesWon+=play();
				
				break;
			
			case "E":
				
				System.out.println("\nTimes won: "+timesWon);
				System.out.println("Times lost: "+(timesPlayed-timesWon));
				System.out.println("\n>>>>> Bye >>>>>");
				
				break;
			}
			
		} while (option.compareTo("E")!=0);

		scan.close();
		
	}
	
}
