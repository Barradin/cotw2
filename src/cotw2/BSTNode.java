/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * BST Node                             *
 ***************************************/
package cotw2;
import java.io.*;

public class BSTNode {
	
	//declare some variables
	private BSTNode left;
	private BSTNode right;
	private RawData key;
	private NameIndex ni;
	FileWriter write;
	PrintWriter p;
	boolean append = true;
	
	/**
	 * constructor for making a node
	 * @param key
	 * @throws IOException 
	 */
	public BSTNode (RawData key) throws IOException{
		this.key = key;
		left = null;
		right = null;
	}

	/**
	 * constructor for the name index node
	 * @param ni
	 */
	public BSTNode(NameIndex ni) {
		// TODO Auto-generated constructor stub
		this.ni = ni;
		left = null;
		right = null;
	}

	//**************************************
	/**
	 * set the right child
	 * @param right
	 */
	public void setRight(BSTNode right){
		this.right = right;
	}
	
	/**
	 * get the right child
	 * @return
	 */
	public BSTNode getRight(){
		return right;
	}
	
	/**
	 * set the left child
	 * @param n1
	 */
	public void setLeft(BSTNode n1){
		this.left = n1;
	}
	/**
	 * get the left child
	 * @return
	 */
	public BSTNode getLeft(){
		return left;
	}
	
	/**
	 * set the raw data key information
	 * @param key
	 */
	public void setKey(RawData key){
		this.key = key;
	}
	
	/**
	 * get it
	 * @return
	 */
	public RawData getKey(){
		return key;
	}
	/**
	 * set the name index key
	 * @param ni
	 */
	public void setKey(NameIndex ni){
		this.ni = ni;
	}
	/**
	 * get it
	 * @return
	 */
	public NameIndex getNI(){
		return ni;
	}
	
	/**
	 * print to backup
	 * @throws IOException
	 */
	public void print() throws IOException{
		File file = new File("NIBackup.txt");
		FileWriter write = new FileWriter(file, append);
		PrintWriter p = new PrintWriter(write);
		p.printf("%s,%s,%d,%d%n", key.getID(), key.getCountryName(), key.getLCP(), key.getRCP());
		p.close();
	}
	/**
	 * close the file
	 */
	public void closeFile(){
		p.close();
	}

}
