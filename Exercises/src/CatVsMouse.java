// @author RodrigoJimenezCorrea

import java.util.Random;
import java.util.Scanner;

class Mouse{
	
	boolean location[][] = new boolean[5][5];
	private Random random = new Random();
	
	Mouse() { 
		
		this.location[random.nextInt(5)][random.nextInt(5)] = true; 
		
	}
	
}

class Cat{
	
	public boolean catchMouse (Mouse mouse, int x, int y) { return mouse.location[x][y]; }
	
}

class Game{

	private Scanner scan;
	
	private int timesPlayed;
	private int timesWon;
	
	Game(){
	
		this.scan = new Scanner(System.in);
		
		this.timesPlayed = 0;
		this.timesWon = 0;
		
	}
	
	public int play(int chances){
	
		int win = 0;
		
		int x = 0;
		int y = 0;
		
		boolean tries[][] = new boolean[5][5];
		
		String guess;
		
		Mouse mouse = new Mouse();
		Cat cat = new Cat();
		
		System.out.println("\n<Game Starts!>");
		
		for (int i=0; i<chances; i++) {
			
			do {
				System.out.println("\nTries left: "+(chances-i));
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
		
		return win;
		
	}
	
	public void start() {
		
		//Scanner scan = new Scanner(System.in);
		String input;
		
		System.out.println("\n[CAT VS MOUSE]");
		System.out.println(" - The Game - ");
		
		do {
			
			System.out.println("\n#    MENU    #");
			System.out.println("---------------");
			System.out.println("[P]lay | [E]xit");
			System.out.println("---------------");
			System.out.print("Option: ");
			
			input = scan.next();
			input = input.toUpperCase(); 

			switch (input) {
			
			case "P":
				
				timesPlayed++;
				timesWon+=play(5);
				
				break;
			
			case "E":
				
				System.out.println("\nTimes won: "+timesWon);
				System.out.println("Times lost: "+(timesPlayed-timesWon));
				System.out.println("\n>>>>> Bye >>>>>");
				
				break;
			
			default:
				
				System.out.println("\nInvalid Option!");
				System.out.println("Please try again");
				
			}
			
		} while (input.compareTo("E")!=0);

		scan.close();
		
	}
	
}

public class CatVsMouse {

	public static void main(String args[]) {
		
		Game game = new Game();
		game.start();
		
	}
	
}
