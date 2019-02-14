// @author RodrigoJimenezCorrea

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class SlotMachine {
	
	
	public static int prize (int n1, int n2, int n3) {
		
		int payout = 0;
		int fours = 0;
		int n[] = {n1,n2,n3};
		
		if (n1==n2 && n2==n3) {
			if (n1==4) { payout = 30; }
			else { payout = 10; }	
		} 
		
		else {
			for(int i=0; i<3; i++) {
				if (n[i] == 4) { fours++; }
			}
			if (fours == 1) { payout = 1; }
			else if (fours == 2) { payout = 4; }
		}
		
		return payout;
	}
	
	public static void main(String[] args) {
		
		int credits = 0;
		int bet = 1;
		int payout;
		
		Scanner scan = new Scanner(System.in);
		String input;
		
		String[] options = {"A","P","S","C","R","T"};
		boolean validOption;
		
		Random random = new Random();
		
		int n1 = 4;
		int n2 = 4;
		int n3 = 4;

		do {
		
			System.out.println("\n| [4th SLOT!] |");
			System.out.println("---------------");
			System.out.println(">>>["+n1+"]["+n2+"]["+n3+"]<<<");
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
		
			input = scan.next();
			validOption = Arrays.stream(options).anyMatch(input:: equals);
			
			if (!validOption) {
				
				System.out.println("\nInvalid Option!");
				System.out.println("Please try again");
				
			}
			
			switch (input) {
			
			case "A":
				
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
				
				break;
			
			case "P":
				
				if (credits >= bet) {
					
					credits -= bet;
					
					n1=random.nextInt(6);
					n2=random.nextInt(6);
					n3=random.nextInt(6);
					
					payout = bet*prize(n1,n2,n3);
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
				
				break;
				
			case "S":
				
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
				
				break;
				
			case "C":
				
				if (credits>0) {
					
					System.out.println("\nCredits payed: "+credits);
					System.out.println("Come back later!");
					
				}
				
				else {
					
					System.out.println("\nNo credits!");
					
				}
				
				credits=0;
				
				break;
				
			case "R":
				
				System.out.println("\nCombination\tPays");
				System.out.println("----------------------");
				System.out.println(" [4][4][4]\tx30");
				System.out.println(" [n][n][n]\tx10");
				System.out.println(" [4][4][x]\tx4");
				System.out.println(" [4][x][x]\tx1");
				
				break;
			}
			
		} while(input.compareTo("T")!=0);
		
		scan.close();
		
	}

}
