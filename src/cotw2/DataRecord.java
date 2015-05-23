/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * Data Record                           *
 ***************************************/
package cotw2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DataRecord {

	//declare stuff
	RandomAccessFile raf;
	private final int REC_SIZE = 3 + 3 + 15 + 13 + 8 + 10 + 4;
	int highLoc = 0;
	
	//****************************************************
	/**
	 * constructor
	 * @throws FileNotFoundException
	 */
	public DataRecord() throws FileNotFoundException{
		raf = new RandomAccessFile("countryData.txt", "rw");
	}
	//*******************************************************************
	/**
	 * writes a record to the random access file
	 * @param aLine
	 * @param RRN
	 * @throws IOException
	 */
	public void write1Record(String aLine, int RRN) throws IOException{
		int offSet = (RRN - 1)  * REC_SIZE;
		raf.seek(offSet);
		if(RRN > highLoc){
			highLoc = RRN;
		}
		write1Record(aLine);
	}
	
	/**
	 * reads a record from the random access file
	 * @param RRN
	 * @return
	 * @throws IOException
	 */
	public String read1Record(int RRN) throws IOException{
		byte[] buffer = new byte[REC_SIZE];
		int offset = (RRN - 1) * REC_SIZE;
		raf.seek(offset);
		int numBytesRead = raf.read(buffer, 0, REC_SIZE);
		
		if(numBytesRead == -1){
			return "-1";
		}
		else{
			String aLine = new String(buffer);
			if (aLine.substring(6).equals(" ")){ 
                return "-1";
			}
            else{
                return aLine;
            }
		}
		
	}
	
	/**
	 * actually write it
	 * @param aLine
	 * @throws IOException
	 */
	public void write1Record(String aLine) throws IOException{
		raf.writeBytes(aLine);		
	}
	
	/**
	 * close file
	 * @throws IOException
	 */
	public void closeFile() throws IOException{
		raf.close();
	}

}
