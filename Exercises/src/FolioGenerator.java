// @author RodrigoJimenezCorrea

import java.util.Random;
import java.io.*;

class FolioGenerator {
	
	public static String secGen(int n){
		
		Random random = new Random();
		int aux;
		int range;
		
		int folioI[] = new int[n+1];
		folioI[0] = 0;
		
		String folioS ="";
		
		for (int i=1; i<n+1; i++) {
			
			if (folioI[i-1]>9) { range = 9; }
			else { range = 16;}
			
			aux = random.nextInt(range);
			folioI[i] = aux;
			folioS += Integer.toHexString(aux).toUpperCase();
			
		}
		
		return folioS;
	}
	
	public static String folioGen(String dBName){
		
		String folio;
		
		do { folio = secGen(9)+"-"+secGen(8)+"-"+secGen(7); } while (FolioGenerator.folioInDB(folio, dBName));
		
		FolioGenerator.addFolioToDB(folio, dBName);
		
		return folio;
		
	}
	
	public static String folioGen(String dBName, String DDD, String stateCodes){
		
		String line = null;
		boolean found = false;
		
		String folio = "NONE";
		
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
			
			do { folio = DDD+secGen(9)+"-"+secGen(8)+"-"+secGen(7); } while (FolioGenerator.folioInDB(folio, dBName));
			
			FolioGenerator.addFolioToDB(folio, dBName);
		}
		
		else {System.out.println( "Error, state code '"+DDD+"' not found"); }
		
		
		
		return folio;
	}
	
	public static boolean folioInDB(String folio, String fileName ) {
		
		String line = null;
		boolean found = false;
		
		try{
			
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader =  new BufferedReader(fileReader);
			
			do{
				
				line = bufferedReader.readLine();
				if (line!=null && folio.compareTo(line) == 0) { found = true; }
				
			} while(line != null);
			
			bufferedReader.close(); 
		}
		
		catch(IOException ex) {
			System.out.println( "Error reading file '"+fileName+"'");
		}
		
		return found;
	}
	
	public static void addFolioToDB(String folio, String fileName) {
		
		try{
			
			FileWriter fileWriter = new FileWriter(fileName, true);
			BufferedWriter bufferedWriter = new BufferedWriter (fileWriter);
			
			bufferedWriter.write(folio);
			bufferedWriter.newLine();
			bufferedWriter.close();
		
		}
		
		catch(IOException ex) {
			System.out.println( "Error writing to file '"+fileName+"'");
		}
			
	}
	
}