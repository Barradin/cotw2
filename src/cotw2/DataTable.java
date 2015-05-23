/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * Data Table                           *
 ***************************************/
package cotw2;

import java.io.*;

public class DataTable {

	//declare some stuff
	private DataRecord dr = new DataRecord();
	private char[] codeA = new char[3];
	private char[] idA = new char[3];
	private char[] countryNameA = new char[15];
	private char[] continentA = new char[13];
	private char[] areaA = new char[8];
	private char[] populationA = new char[10];
	private char[] lifeExpA = new char[4];
	private boolean append = true;

	//************************************************************
	/**
	 * constructor
	 * @throws FileNotFoundException
	 */
	public DataTable() throws FileNotFoundException {

	}

	//*****************************************************************
	/**
	 * clean up the record furthur for insertion
	 * @param code
	 * @param id
	 * @param cn
	 * @param co
	 * @param a
	 * @param pop
	 * @param le
	 * @throws IOException
	 */
	public void insert(String code, int id, String cn, String co, long a,
			long pop, float le) throws IOException {
		// TODO Auto-generated method stub
		codeA = code.toCharArray();
		idA = Integer.toString(id).toCharArray();
		countryNameA = cn.toCharArray();
		continentA = co.toCharArray();
		areaA = Long.toString(a).toCharArray();
		populationA = Long.toString(pop).toCharArray();
		lifeExpA = Float.toString(le).toCharArray();
		String temp1 = new String(codeA);
		String temp2 = new String(idA);
		String temp3 = new String(countryNameA);
		temp3 = temp3.substring(0, Math.min(temp3.length(), 15));
		String temp4 = new String(continentA);
		String temp5 = new String(areaA);
		String temp6 = new String(populationA);
		String temp7 = new String(lifeExpA);
		String aLine = padLeft(temp1,3) + padLeft(temp2, 3)
				+ padRight(temp3, 15) + padRight(temp4, 13) + padLeft(temp5, 8)
				+ padLeft(temp6, 10) + padLeft(temp7, 4);
		dr.write1Record(aLine, id);
	}

	/**
	 * read a record
	 * @param RRN
	 * @return
	 * @throws IOException
	 */
	public String read(int RRN) throws IOException {
		String aLine = dr.read1Record(RRN);

		return aLine;
	}

	/**
	 * close a file
	 * @throws IOException
	 */
	public void closeFile() throws IOException {
		dr.closeFile();
	}

	/**
	 * padding the string so it will fit
	 * @param s
	 * @param size
	 * @return
	 */
	public String padRight(String s, int size) {
		int padSize = size - s.length();
		String pad = " ";
		if (padSize == 0) {
			return s;
		} else {
			for (int i = 0; i < padSize; i++) {
				s += pad;
			}
			return s;
		}
	}

	/**
	 * pad it some more to fit
	 * @param s
	 * @param size
	 * @return
	 */
	public String padLeft(String s, int size) {
		int padSize = size - s.length();
		String pad = " ";
		if (padSize == 0) {
			return s;
		} else {
			for (int i = 0; i < padSize; i++) {
				s = pad + s;
			}
			return s;
		}
	}
	
	/**
	 * for the various status messages throughout the program
	 * @param s
	 * @param n
	 * @throws IOException
	 */
	public void writeStatus(String s, int n) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Log.txt");
		FileWriter write = new FileWriter(file, append);
		PrintWriter p = new PrintWriter(write);
		if(n == 0){
		p.printf(s + "%n");
		}
		else{
			p.printf(s + " " +  n + " countries processed.%n");
		}
		p.close();
	}
	
	/**
	 * more status messages
	 * @param s
	 * @throws IOException
	 */
	public void writeStatus(String s) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Log.txt");
		FileWriter write = new FileWriter(file, append);
		PrintWriter p = new PrintWriter(write);
		p.printf(s + "%n");		
		p.close();
		
	}

		/**
	 * writing stuff to the log file when given two strings
	 * @param tranCode
	 * @param otherTran
	 * @throws IOException
	 */
	public void writeToLog(String tranCode, String otherTran) throws IOException {
		// TODO Auto-generated method stub
		String[] temp;
		File file = new File("Log.txt");
		FileWriter write = new FileWriter(file, append);
		PrintWriter p = new PrintWriter(write);
		temp = otherTran.split(",");
		
		p.printf("%s %s,%03d,%s,%s,%.1f,%d,%.1f %n", tranCode,
				temp[0].substring(31,34), Integer.parseInt(temp[1]), temp[2].replace("'",""), temp[3].replace("'",""),
				Float.parseFloat(temp[5]), Long.parseLong(temp[7]), Float.parseFloat(temp[8]));
		
		p.close();
	}

	/**
	 * trans data method that cleans up the data furthur for insertion
	 * @param otherTran
	 * @throws IOException
	 */
		public void insertTrans(String otherTran) throws IOException {
			String[] temp = otherTran.split(",");
			String code = temp[0].substring(31,34);
			int id = Integer.parseInt(temp[1]);
			String cn = temp[2].replace("'", "");
			String co = temp[3].replace("'","");
			Long a = Long.parseLong(temp[5]);
			Long pop = Long.parseLong(temp[7]);
			Float le = Float.parseFloat(temp[8]);	
			codeA = code.toCharArray();
			idA = Integer.toString(id).toCharArray();
			countryNameA = cn.toCharArray();
			continentA = co.toCharArray();
			areaA = Long.toString(a).toCharArray();
			populationA = Long.toString(pop).toCharArray();
			lifeExpA = Float.toString(le).toCharArray();
			String temp1 = new String(codeA);
			String temp2 = new String(idA);
			String temp3 = new String(countryNameA);
			temp3 = temp3.substring(0, Math.min(temp3.length(), 15));
			String temp4 = new String(continentA);
			String temp5 = new String(areaA);
			String temp6 = new String(populationA);
			String temp7 = new String(lifeExpA);
			String aLine = padLeft(temp1,3) + padLeft(temp2, 3)
					+ padRight(temp3, 15) + padRight(temp4, 13) + padLeft(temp5, 8)
					+ padLeft(temp6, 10) + padLeft(temp7, 4);
			dr.write1Record(aLine, id);
			
		}

}
