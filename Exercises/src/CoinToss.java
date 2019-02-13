// @author RodrigoJimenezCorrea

import java.util.Random;

class tossGame{
	
	int totalOfTossDone;
	int totalOfHeads;
	int totalOfTails;
	
	tossGame(){
		
	this.totalOfTossDone = 0;
	this.totalOfHeads = 0;
	this.totalOfTails = 0;

	}
	
	public void toss (int n){
		
		int result;
		Random random = new Random();
		
		for (int i=0; i<n; i++) {
			result = random.nextInt(2);
			
			if (result == 1) { totalOfHeads++; } else { totalOfTails++; }
				
			totalOfTossDone++;
			
		}
		
	}
	
	public void printResults(){
		
		System.out.println("Total of toss done: "+totalOfTossDone);
		System.out.println("Total of Heads: "+totalOfHeads+" | Total of Tails: "+totalOfTails);
		
	}
	
}

public class CoinToss {

	public static void main(String[] args) {

		tossGame game1 = new tossGame();
		
		game1.toss(10);
		game1.printResults();
		
	}

}
