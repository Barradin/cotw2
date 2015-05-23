/****************************************
 * Adam Tracy                           *
 * Countries of the World Assignment 2  *
 * Name Index                           *
 ***************************************/
package cotw2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class NameIndex {

	//declare stuff
	private BSTNode root;
	private boolean append = true;
	private String key;
	private int drp;
	private int lcp;
	private int rcp;
	//**********************************
	/**
	 * constructor
	 */
	public NameIndex() {
	}
	
	/**
	 * constructor with parameters
	 * @param key
	 * @param drp
	 */
	public NameIndex(String key, int drp){
		this.key = key;
		this.drp = drp;
		this.lcp = -1;
		this.rcp = -1;
	}
	//*************************************
	/**
	 * method to begin traversing the BST
	 * @return
	 */
	public BSTNode getRoot() {
		return root;
	}

	/**
	 * method to build the BST from the raw data information
	 * @param key
	 * @param i
	 * @throws IOException
	 */
	public void insertBST(RawData key, int i) throws IOException {
		BSTNode n1 = new BSTNode(key);
		if (root == null) {
			root = n1;
		} else {
			BSTNode insNode = root;
			BSTNode parent;
			while (true) {
				parent = insNode;
				if (key.getCountryName().compareTo(
						insNode.getKey().getCountryName()) < 0) {
					insNode = insNode.getLeft();
					if (insNode == null) {
						parent.setLeft(n1);
						parent.getKey().setLCP(i);
						return;
					}
				} else {
					insNode = insNode.getRight();
					if (insNode == null) {
						parent.setRight(n1);
						parent.getKey().setRCP(i);
						return;

					}
				}
			}

		}
	}
	/**
	 * print the BST in order
	 * @param n
	 * @throws IOException
	 */
	public void printNIInOrder(BSTNode n) throws IOException{
		if(n != null){
			printNIInOrder(n.getLeft());
			n.print();
			printNIInOrder(n.getRight());
		}		
	}
	
	/**
	 * writes name index array to another backup file
	 * easier to read from seperate file
	 * @param i 
	 * @param string 
	 * @throws IOException
	 */
	public void writeNIToBackup(String string, int i) throws IOException {
		File file = new File("NIBackup.txt");
		FileWriter write = new FileWriter(file, append);
		PrintWriter p = new PrintWriter(write);
		p.printf("%d,%s%n", i, string);
		p.close();
	}

	/**
	 * method for building the BST when userApp needs it
	 * @param ni
	 * @param n
	 */
	public void insertBST(NameIndex ni, int n) {
		// TODO Auto-generated method stub
			BSTNode n1 = new BSTNode(ni);
			if (root == null) {
				root = n1;
		//		System.out.println("Inserted in root.");
			} else {
				BSTNode insNode = root;
				BSTNode parent;
				while (true) {
					parent = insNode;
					if (ni.getKey().compareTo(
							insNode.getKey().getCountryName()) < 0) {
						insNode = insNode.getLeft();
						if (insNode == null) {
							parent.setLeft(n1);
							parent.getKey().setLCP(n);
							System.out.println("Inserted.");
							return;
						}
					} else {
						insNode = insNode.getRight();
						if (insNode == null) {
							parent.setRight(n1);
							parent.getKey().setRCP(n);
							System.out.println("Inserted.");
							return;

						}
					}
				}
			}
	}
	
	/**
	 * get the key for data comparison
	 * @return
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * get the drp
	 * @return
	 */
	public int getDRP(){
		return drp;
	}
	
	/**
	 * set the left child
	 * @param lcp
	 */
	public void setLCP(int lcp){
		this.lcp = lcp;
	}
	
	/**
	 * get the left child
	 * @return
	 */
	public int getLCP(){
		return lcp;
	}
	
	/**
	 * set the right child
	 * @param rcp
	 */
	public void setRCP(int rcp){
		this.rcp = rcp;
	}
	/**
	 * get the right child
	 * @return
	 */
	public int getRCP(){
		return rcp;
	}	
	
	}
	
	
