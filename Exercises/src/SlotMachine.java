// @author RodrigoJimenezCorrea

import java.util.Scanner;
import java.util.Random;

class SlotMachine {
	
	private Scanner scan = new Scanner(System.in);
	private Random random = new Random();
	
	private int credits;
	private int bet;
	
	private int combination[] = new int[4];
	
	private String input;
	private boolean validOption;
	
	SlotMachine(){
		
		this.credits = 0;
		this.bet = 1;
		
		for (int i=0; i<3; i++) { this.combination[i] = 4; }
		
	}
	
	
	private int prize () {
		
		int payout = 0;
		int fours = 0;
		
		if (combination[0]==combination[1] && combination[1]==combination[2]) {
			if (combination[0]==4) { payout = 30; }
			else { payout = 10; }	
		} 
		
		else {
			for(int i=0; i<3; i++) {
				if (combination[i] == 4) { fours++; }
			}
			if (fours == 1) { payout = 1; }
			else if (fours == 2) { payout = 4; }
		}
		
		return payout;
	}
	
	
	private void printMenu() {
		
		System.out.println("\n| [4th SLOT!] |");
		System.out.println("---------------");
		System.out.println(">>>["+combination[0]+"]["+combination[1]+"]["+combination[2]+"]<<<");
		System.out.println("---------------");
		System.out.println("Credits: "+credits);
		System.out.println("Bet: "+bet);
		System.out.println("---------------");
		System.out.println("[A]dd Credit");
		System.out.println("[P]lay ");
		System.out.println("[S]et Bet ");
		System.out.println("[C]ash ");
		System.out.println("[R]ules ");
		System.out.println("[T]urn off ");
		System.out.println("---------------");
		System.out.print("Option: ");
		
	}
	
	private void printRules() {
		
		System.out.println("\nCombination\tPays");
		System.out.println("----------------------");
		System.out.println(" [4][4][4]\tx30");
		System.out.println(" [n][n][n]\tx10");
		System.out.println(" [4][4][x]\tx4");
		System.out.println(" [4][x][x]\tx1");
		
	}

	
	private void addCredits(){
		
		
		do {
			
			System.out.print("\nCoin: $");
			input = scan.next();
			
			if (!input.matches("[125]")) {
				
				validOption = false;
				System.out.println("\nOnly accepts \n$1,$2 and $5");
				
			}
			
			else {
				
				validOption = true;
				credits += Character.getNumericValue(input.charAt(0));
				
				if (credits>99) { credits=99; }
				
			}
			
		} while(!validOption);
		
	}
	
	private void setBet() {
		
		String input;
		boolean validOption;
		
		do {
			
			System.out.print("\nNew bet: ");
			input = scan.next();
			
			if (!input.matches("[12345]")) {
				
				validOption = false;
				
				System.out.println("\nBet must be a");
				System.out.println("number from 1 to 5");
				
			}
			
			else {
				
				validOption = true;
				bet = Character.getNumericValue(input.charAt(0));
				
			}
			
		} while(!validOption);
		
	}
	
	private void cash() {
		
		if (credits>0) {
			
			System.out.println("\nCredits payed: "+credits);
			System.out.println("Come back later!");
			
			credits = 0;
			
		}
		
		else {
			
			System.out.println("No credits!");
			
		}
		
	}
	
 	private void play() {
		
		int payout;
		
		if (credits >= bet) {
			
			credits -= bet;
			
			for (int i=0; i<3; i++) {
				combination[i] = random.nextInt(6);
			}
			
			payout = bet*prize();
			credits += payout;

			switch (payout){
			
			case 0:
				System.out.println("\nBetter luck next time!");
				break;
			case 1:
				System.out.println("\nYou won 1 credit!");
				break;
			default:
				System.out.println("\nYou won "+payout+" credits!");
			}
		}
		else {
			System.out.println("\nNo enought credits!");
		}
		
	}
	

	public void turnOn() {
		
		do {
		
			printMenu();
		
			input = scan.next();
			
			switch (input) {
			
			case "A": addCredits(); break;
			
			case "P": play(); break;
				
			case "S": setBet(); break;
				
			case "C": cash(); break;
				
			case "R": printRules(); break;
				
			case "T":
				
				System.out.println("\n< Turned off >");
				
				break;
				
			default:
				
				System.out.println("\nInvalid Option!");
				System.out.println("Please try again");
			
			}
			
		} while(input.compareTo("T")!=0);
		
		scan.close();
		
	}

}