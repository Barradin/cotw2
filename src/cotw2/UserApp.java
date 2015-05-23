/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * User App                             *
 ***************************************/
package cotw2;

import java.io.*;
import java.util.Scanner;

public class UserApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// declare some variables
	//	String transDataSuffix = args[0];
		String transDataSuffix = "2";
		String tranCode = null;
		String otherTran = null;
		String temp[];
		String line;
		String data = null;
		int n = 0;

		// objects as well
		UI ui = new UI(transDataSuffix);
		DataTable dt = new DataTable();
		NameIndex ni = new NameIndex();
		dt.writeStatus("STATUS > UserApp Started", n);
		dt.writeStatus("STATUS > TransDataFile Opened. TransData "
				+ transDataSuffix);
		//open up backup
		File backupFile = new File("NIBackup.txt");
		Scanner b2File = new Scanner(backupFile);

		//read from backup and build a new BST
		while (b2File.hasNext()) {
			line = b2File.nextLine();
			temp = line.split(",");			
			ni = new NameIndex(temp[1], Integer.parseInt(temp[0]));
			ni.insertBST(ni, n);
			n++;
		}


		// close files
		b2File.close();

		// ********************************************************************************
		// loop till done. process the transdata information and switch as
		// necessary
		n = 0;
		while (!ui.isDone()) {
			tranCode = ui.processTrans();
			otherTran = ui.getRestOfLine();
			if (tranCode != null) {
				switch (tranCode) {

				case "IN": // insert new information into tables
					dt.writeToLog(tranCode, otherTran);
					dt.insertTrans(otherTran);
					temp = otherTran.split(",");
					ni = new NameIndex(temp[2].replace("'",""), Integer.parseInt(temp[1]));
					ui.writeToLog("Ok, Country Inserted");
					n++;
					break;

				case "DN": // delete by name -not working-
					ui.writeToLog(tranCode);
					ui.writeToLog("[SORRY! Delete by name module not yet working.]");
					n++;
					break;

				case "DI":// delete by id -not working-
					ui.writeToLog(tranCode);
					ui.writeToLog("[SORRY! Delete by ID module not yet working.]");
					n++;
					break;

				case "SN":// select a country by its name
					ui.writeToLog(tranCode, otherTran);
					ni = new NameIndex(otherTran, -1);				
					n++;
					break;

				case "SI":// select a country by its ID
					ui.writeToLog(tranCode, otherTran);
					if(otherTran.equals("0")){
					}
					else{
						data = dt.read(Integer.parseInt(otherTran));
					}
					if (data != "-1") {
						ui.writeToLog(data);
					}
					
					else {
						ui.writeToLog("Invalid ID.");
					}
					n++;
					break;

				case "AN":// print all the countries by name order
					ui.writeToLog(tranCode);
					ui.writeToLog("CDE-IDName-----------Continent------Area--PopulationLife-%n");
					ui.writeToLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					n++;
					break;

				case "AI":// print all the countries by ID order
					ui.writeToLog(tranCode);
					ui.writeToLog("CDE-IDName-----------Continent------Area--PopulationLife-%n");
					for(int i = 1; i < 42; i++){
						data = dt.read(i);
						if(data != "-1"){
						ui.writeToLog(data);
						}
					}
					ui.writeToLog("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					n++;
					break;

				default:// if nothing else, make the user feel bad.
					ui.writeToLog("Invalid Code.%n");
					n++;
					break;

				}
			}
		}

		// wrap things up
		dt.writeStatus("STATUS > UserApp Finished", n);
		ui.finishUp();
		dt.writeStatus("STATUS > TransDataFile closed");

	}
}
