/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * Test Driver                          *
 ***************************************/
package cotw2;

import java.io.*;

public class TestDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//open up some stuff for sending in data
		String [] fileNameSuffix = new String[] {"Sample"};
		String [] transDataSuffix = new String[] {"1","2","3"};
		File cFile = new File("countryData.txt");
		File cFile2 = new File("NIBackup.txt");
		File cFile3 = new File("Log.txt");
		//delete files
		if(cFile.exists()){
			cFile.delete();
		}
		if(cFile2.exists()){
			cFile2.delete();
		}
		if(cFile3.exists()){
			cFile3.delete();
		}
		//run programs
		Setup.main(new String[]{fileNameSuffix[0]});
		PrettyPrintUtility.main(args);
		for(int i = 0; i < 3; i++){
			UserApp.main(new String[]{transDataSuffix[1]});
		}
		PrettyPrintUtility.main(args);
	}

}
