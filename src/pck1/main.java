package pck1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class main {
	static MyList linkedList= new MyList();

	/**
	 * MAIN
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input= new Scanner(System.in);
		int choose= -1;
		
		do {
			showMenu();		
			choose= input.nextInt();
			switch(choose) {
				case 1:
					readFromFile();
					printList(linkedList);
					break;
				
				case 2:
					inputAndAddToTail();
					break;
				
				case 3:					
					printList(linkedList);
					break;
				
				case 4:
					saveToFile(linkedList);
					break;
				
				case 5:
					searchID(linkedList);
					break;
				
				case 6:
					deleteById(linkedList);
					break;
				
				case 7:
					sortById(linkedList);
					printList(linkedList);
					break;
				
				case 8:
					convertToBinary(linkedList);
					break;
				
				case 9:
					loadToStackAndPrint(linkedList);
					break;
				
				case 10:
					loadToQueueAndPrint(linkedList);
					break;
	
			}			
		}while(choose != 0);
		
	}
	
	
	/**
	 * SHOW MENU
	 * @throws FileNotFoundException 
	 */
	public static void showMenu() throws FileNotFoundException {

		output("1. Load data from file and display.");
		output("2. Input & add to the end.");
		output("3. Display data.");
		output("4. Save product list to file.");
		output("5. Search by ID");
		output("6. Delete by ID.");
		output("7. Sort by ID.");
		output("8. Convert to Binary.");
		output("9. Load to stack and display.");
		output("10.Load to queue and display.");
		output("0. Exit.");
		
	}

	/**
	 * READ FILE TEXT
	 */

	
	public static void readFromFile(){
		File file= new File("data.txt");
		try {
			FileReader fr= new FileReader (file);
			BufferedReader br= new BufferedReader(fr);
			String line= "";
			while(true) {
				//read each line in file
				line= br.readLine();
				
				//condition for stopping the loop
				if(line == null) {		
					break;
				}
				
				//create an array, each element is seperated by ";"
				String txt[]= line.split("\\;");
				String maSp= txt[0];
				String tenSp= txt[1];				
				int soLuong= Integer.parseInt(txt[2]);
				double donGia= Double.parseDouble(txt[3]);
				
				//create an object
				Product x= new Product(maSp, tenSp, soLuong, donGia ); 

				//insert object to linked list
				linkedList.insertAtTail(x);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	
	/**
	 * PRINT LIST
	 * 
	 */
	public static void printList(MyList list) {
		Node currNode = list.head;
		
		output("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
		// Print the data at current node
			output(currNode.info.toString());
			
		// Go to next node
		currNode = currNode.next;
		}
	}

	
	/**
	 * INPUT AND ADD TO TAIL
	 */

	public static void inputAndAddToTail() {
		Scanner input= new Scanner(System.in);
				
		output("Input new ID: ");
		String maSp= input.next();
		
		input.nextLine();
		output("Input Product's Name: ");
		String tenSp= input.next();
		
		input.nextLine();
		output("Input Product's quantity: ");
		int soLuong= input.nextInt();
		
		output("Input Product's price: ");
		double donGia= input.nextDouble();
		
		//create an object
		Product x= new Product(maSp, tenSp, soLuong, donGia ); 
		
		//insert object to linked list
		linkedList.insertAtTail(x);
		
		
	}
	

	/**
	 * SAVE TO FILE
	 */
	public static void saveToFile(MyList list) {
		File file= new File( "data.txt");
		try {
			FileWriter fw= new FileWriter(file, false);
			BufferedWriter bw= new BufferedWriter(fw);
			
			Node curr= list.head;
			
			// Traverse through the LinkedList
			while(curr != null) {
				String k= curr.info.toString();
				
				//write into file
				bw.write(k);
				
				//down the line
				bw.newLine();
				
				//go to the next node
				curr= curr.getNext(); 
			}
			
			bw.close();
			fw.close();
			output("SUCCESS !!!");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("ERROR !!!");
			
		}
	}
	
	
	/**
	 * SEARCH BY ID
	 */
	
	public static void searchID(MyList list) {
		Scanner input= new Scanner(System.in);
		output("Input the ID to search: ");
		
		//Input id want to search
		String id= input.next();

		Node curr= list.head;
		int check= 0;
		// Traverse through the LinkedList
		while(curr != null) {
			String temp= curr.info.getMaSP();
			
			//check the result
			if(id.equals(temp)) {
				output("FOUND !!!");
				output(curr.info.toString());
				check++;
			}
				
			//go to the next node
			curr= curr.getNext(); 
						
		}
		if(check== 0) {
			System.err.println("NOT FOUND !!!");
		}
	
	}
	
	/**
	 * DELETE BY ID
	 */
	
	public static void deleteById(MyList list) {
		Scanner input= new Scanner(System.in);
		output("Input the ID to delete: ");
		
		int check= 0;
		
		//Input id want to delete
		String idWantToDelete= input.next();
	
	
		 // If linked list is empty
        if (list.head == null)
            return;
		
		//store the current node
		Node curr= list.head;
		
		//store the node behind current node
		Node currAfter= curr.next;


		//if head node needs to remove
		if(idWantToDelete.equals(curr.info.getMaSP())) {
				list.head= currAfter;
				return;
			}

		// Traverse through the LinkedList
		while(curr != null) {
			
			if(currAfter== null ) {
				System.err.println("NOT FOUND !!!");
				break;
			}
			//get id of product of curentAfter in linked list
			String idOfProduct= currAfter.info.getMaSP();
			
			if(idWantToDelete.equals(idOfProduct)) {
				check++;
				
				//set the pointer of current node
				curr.setNext(curr.next.next);

				output("FOUND !!!");
				
			}
		
			//current node go to next position
			curr= curr.getNext();
			
			//currentAfter node go to next position
			currAfter= currAfter.getNext(); 
		
		}
	}
	
	
	/**
	 * SORT BY ID
	 */
	public static void sortById(MyList list) {
		
		Node pi, pj;
		Product t;
		pi= list.head;
		
		//Traverse through the LinkedList from pi node
		while( pi != null) {
	
			//pj is the next node of pi node
			pj= pi.getNext();
			
			//Traverse through the LinkedList from pj node
			while(pj != null) {
				
				if (pi.info.getMaSP().compareTo( pj.info.getMaSP()) > 0)
                {
       
					t= pi.info;
					pi.info= pj.info;
					pj.info= t;
                }
				pj=pj.next;
			
			}
			 pi=pi.next;
					
		}
		
	}
	
	
	/**
	 * CONVERT TO BINARY
	 */

	public static void convertToBinary(MyList list) {
		
		//store the head node
		Node p= list.head;
		
		//get quantity of head node
		int num= p.info.getSoLuong();
		
		//print the result
		output("Quantity= "+ num + "=>" + Integer.toString(num,2));
		
	}
	
	
	/**
	 * LOAD TO STACK AND PRINT
	 */
	
	public static void loadToStackAndPrint(MyList list) {
		
		//create an object of linked stack
		LinkedStack stack= new LinkedStack();
	
		File file= new File("data.txt");
		try {
			FileReader fr= new FileReader (file);
			BufferedReader br= new BufferedReader(fr);
			String line= "";
			while(true) {
				//read each line in file
				line= br.readLine();
				
				//condition for stopping the loop
				if(line == null) {		
					break;
				}
				
				//create an array, each element is seperated by ";"
				String txt[]= line.split("\\;");
				String maSp= txt[0];
				String tenSp= txt[1];				
				int soLuong= Integer.parseInt(txt[2]);
				double donGia= Double.parseDouble(txt[3]);
				
				//create an object
				Product x= new Product(maSp, tenSp, soLuong, donGia ); 

				//insert object to linked list
				stack.push(x);

			}
			
			//print the stack	
			stack.print();

		} catch (Exception e) {
			// TODO: handle exception
		}

	
	}
	
	/**
	 * LOAD TO QUEUE AND PRINT
	 */
	public static void loadToQueueAndPrint(MyList list) {
		
		//create an object of queue 
		LinkedQueue queue= new LinkedQueue();

		File file= new File("data.txt");
		try {
			FileReader fr= new FileReader (file);
			BufferedReader br= new BufferedReader(fr);
			String line= "";
			while(true) {
				//read each line in file
				line= br.readLine();
				
				//condition for stopping the loop
				if(line == null) {		
					break;
				}
				
				//create an array, each element is seperated by ";"
				String txt[]= line.split("\\;");
				String maSp= txt[0];
				String tenSp= txt[1];				
				int soLuong= Integer.parseInt(txt[2]);
				double donGia= Double.parseDouble(txt[3]);
				
				//create an object
				Product x= new Product(maSp, tenSp, soLuong, donGia ); 

				//insert object to linked list
				queue.enqueue(x);

			}
			
			//print the stack	
			queue.printQueue();

		} catch (Exception e) {
			// TODO: handle exception
		}
	

	}
	

	/**
	 * SAVE TO FILE CONSOLE OUTPUT
	 * @throws FileNotFoundException 
	 */
	
	public static void output(String x) {
		System.out.println(x);
		File file= new File("console_output.txt");
		try {
			FileWriter fw= new FileWriter(file, true);
			BufferedWriter bw= new BufferedWriter(fw);

				//write into file
				bw.write(x);			
				//down the line
				bw.newLine();	
				
				//close the file
				bw.close();
				fw.close();
				
		}	

		 catch (Exception e) {
			// TODO: handle exception
			System.err.println("ERROR !!!");
			
		}
	}
	

}
