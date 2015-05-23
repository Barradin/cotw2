/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * PrettyPrint                          *
 ***************************************/
package cotw2;

import java.io.*;
import java.util.Scanner;

public class PrettyPrintUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//declare variables and open up stuff
		RandomAccessFile raf = new RandomAccessFile("countryData.txt", "r");
		boolean append = true;
		final int REC_SIZE = 3 + 3 + 15 + 13 + 8 + 10 + 4;
		int RRN = 1;
		File file = new File("Log.txt");
		FileWriter write = new FileWriter(file, append);
		PrintWriter p = new PrintWriter(write);
		File backupFile = new File("NIBackup.txt");
		Scanner b2File = new Scanner(backupFile);
		String line;
		String[] temp;
		
		//read through the RAF and print out data to log.
		p.printf("CDE-IDName-----------Continent------Area--PopulationLife-%n");
		for(int i = 0; i < 40; i++){
		byte[] buffer = new byte[REC_SIZE];
		int offset = (RRN - 1) * REC_SIZE;
		raf.seek(offset);
		int numBytesRead = raf.read(buffer, 0, REC_SIZE);
		
		if(numBytesRead != -1){
			String aLine = new String(buffer);
			p.printf("%s%n",aLine);
		}
		RRN++;
		}
		p.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++%n");
		p.printf("ID--Name----------------LCP-RCP%n");
		//read the backupfile and print the data to log.
		while(b2File.hasNext()){
			line = b2File.nextLine();
			temp = line.split(",");
			p.printf("%03d %-18s %3s %3s%n", Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]);
		}
		p.printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++%n");
		//close stuff
		b2File.close();
		raf.close();
		p.close();
	}

}
