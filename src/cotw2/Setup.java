/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * Setup                                *
 ***************************************/
package cotw2;

import java.io.*;
import java.util.Scanner;

public class Setup {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// declare variables
		//String fileNameSuffix = args[0];
		String fileNameSuffix = "Sample";
		RawData rd = new RawData(); // object to take in country data
		DataTable dt = new DataTable();
		NameIndex ni = new NameIndex();
		File file = new File("A2RawData" + fileNameSuffix + ".csv");
		Scanner cFile = new Scanner(file);
		int i = 0;
		//status messages
		dt.writeStatus("STATUS > Setup Started.");
		dt.writeStatus("STATUS > RAW DATA file opened. A2RawData"
				+ fileNameSuffix + ".csv");

		// ****************************************************************************
		//read the sample file and insert data into the random file (Data table)
		while (cFile.hasNext()) {
			String line = cFile.nextLine();
			if (line.startsWith("INSERT INTO")) {
				rd = rd.Read1File(line, rd);
				dt.insert(rd.getCode(), rd.getID(), rd.getCountryName(),
						rd.getContinent(), rd.getArea(), rd.getPopulation(),
						rd.getLifeExp());
				ni.insertBST(rd, i);
				//ni.writeNIToBackup(rd.getCountryName(), rd.getID());
				i++;
			}
		}
		//print BST in order to backup
		ni.printNIInOrder(ni.getRoot());

		
		 //*****************************************************************************
		
		 //write backup files and end messages
		rd.finishUp(cFile);
		dt.closeFile();
		dt.writeStatus("STATUS > RAW DATA file closed");
		dt.writeStatus("STATUS > Setup Finished", i);

	}
}