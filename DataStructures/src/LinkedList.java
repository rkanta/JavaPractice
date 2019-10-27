import java.util.Scanner;

public class LinkedList {

	class Node {
		int lData;
		Node next;

		Node(int lData) {
			this.lData = lData;
		}
	}

		protected Node head = null;
		protected Node tail = null;

		public void addToFront(int value) {
			Node newNode = new Node(value);
			newNode.next = head;
			head = newNode;
			if (newNode.next == null) {
				tail = newNode;
			}
		}

		public void addToTail(int value) {
			Node newNode = new Node(value);
			if (tail == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		
		public void addAtIndex(int index, int value) {
			Node newNode = new Node(value);
			Node current = head;
			if(index < 0) {
				throw new IndexOutOfBoundsException();
			}else if (index == 0) {
				addToFront(value);
			}else {
			for(int i=0; i < index-1;i++) {
				if(current == null) {
					throw new IndexOutOfBoundsException();
				}
				
				if(current.next == null) {
					tail = newNode;
				}else {
				current = current.next;	
				}
				
			}
			newNode.next = current.next;
			current.next = newNode;
			}
			
		}
		
		public void printLinkedList() {
			Node n = head;
			while(n != null) {
				System.out.println(n.lData + "   ");
				n = n.next;
			}
		}
		
		public static void main(String args[]) {
			LinkedList lList = new LinkedList();
			
			Scanner readNum = new Scanner(System.in);
			
			while (readNum.hasNextInt()) {
				lList.addToTail(readNum.nextInt());
				
			}
			
			lList.printLinkedList();
			readNum.nextLine();
			System.out.println("Do you want exit or continue. type C for continue or type exit");
			readNum.nextLine();
			while(!readNum.hasNext("exit")) {
				
			System.out.println("Do you want to add to front? : type y or n" );
			readNum.nextLine();
			
			if(readNum.hasNext("y")) {
				System.out.println("please enter next integer to add to linked list " );
				readNum.nextLine();
				lList.addToFront(readNum.nextInt());
				lList.printLinkedList();
			}
			
			System.out.println("Do you want to add to tail? : type y or n" );
			readNum.nextLine();
			if(readNum.hasNext("y")) {
				System.out.println("please enter next integer to add to linked list at tail end " );
				readNum.nextLine();
				lList.addToTail(readNum.nextInt());
				lList.printLinkedList();
			}
			System.out.println("Do you want to add at index? : type y or n" );
			readNum.nextLine();
			if(readNum.hasNext("y")) {
				System.out.println("please enter  index :" );
				readNum.nextLine();
				int index = readNum.nextInt();
				System.out.println("value of index entered : " + index);
				System.out.println("please enter next integer to add at index :" );
				readNum.nextLine();
				int value = readNum.nextInt();
				System.out.println("value entered : " + value);
				lList.addAtIndex(index,value);
				lList.printLinkedList();
			}
			System.out.println("Do you want exit or continue. type C for continue or type exit");
			readNum.nextLine();

			}
			readNum.close();
			
		}
	

}
