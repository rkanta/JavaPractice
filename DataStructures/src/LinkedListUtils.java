
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	public static void insertSorted(LinkedList<Integer> list, int value) {

		/* IMPLEMENT THIS METHOD! */
		if (!(list == null)) {

			int sz = list.size();
			if (sz == 0) {// {1,12,33,45,58,68,71,77,82}
				list.add(value);
			} else if (value < list.getLast()) {// {1,12, 33}
				for (int i = 0; i < sz; i++) {
					if (value <= list.get(i)) {
						list.add(i, value);
						break;
					}

				}
			} else {
				list.add(value);
			}
		}

	}

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		/* IMPLEMENT THIS METHOD! */
		
		if ((!(list == null)) && (N > 0)) {
			int sz = list.size();
			
			// Collections.sort(list, Collections.reverseOrder());

			if (N <= sz && !(sz == 1)) {
				
				for(int i = 0 ; i < N ; i++) {
				
				String maxString = "";
				
				ListIterator<String> listIter = list.listIterator();
				
				while(listIter.hasNext()) {
					String temp = listIter.next();
					if(temp.compareTo(maxString)>0) {
						maxString = temp;
					}
				}
				
				// remove duplicates in N highest strings

					while (list.contains(maxString)) {
						list.removeFirstOccurrence(maxString);
					}

				
				
				}

			} else {

				list.clear();
			}
		}

	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */
		
		
		if (one == null || two == null) {
			return false;
		}

		if (one.isEmpty() || two.isEmpty()) {
			return false;
		}
		
		

		if (!one.containsAll(two)) {
			return false;
			
			
		}else {
			
			System.out.println("Printiting initial one list : ");
			for(int s : one) {
				System.out.println(s);
			}
			System.out.println("Printiting initial two list : ");
			for(int k : two) {
				System.out.println(k);
			}
			
			int fEle = two.getFirst();
			ListIterator<Integer> listtwoIter =  two.listIterator();
			
			
			
				int indexofTwoinOne = one.indexOf(fEle);
				ListIterator<Integer> listoneIter =  one.listIterator(indexofTwoinOne);
				
				
				while(listtwoIter.hasNext()) {
					int a =listtwoIter.next();
					int b = listoneIter.next();
					System.out.println("List two item  :"+a + "List one item  :   " + b);
					if(a != b) {
						return false;
					}
					
				}
			
			
		}

		return true; // this line is here only so this code will compile if you don't modify it
	}

	public static void main(String args[]) {
		LinkedListUtils lUtils = new LinkedListUtils();
		int num[] = { 1, 12, 33, 45, 58, 68, 71, 77, 82 };
		int num1[] = { 33, 45, 58, 68, 71 };

		LinkedList<Integer> lLNumbers1 = new LinkedList<Integer>();
		

		LinkedList<Integer> lLNumbers2 = new LinkedList<Integer>();
		/*
		for (int i = 0; i < num1.length; i++) {
			lLNumbers2.add(i, num1[i]);
		}
*/
		LinkedList<String> lStr = new LinkedList<String>();
		lStr.add("rajesh");
		lStr.add("kanta");
		lStr.add("rakesh");
		/*
		 * lStr.add("kantha"); lStr.add("Sandeep"); lStr.add("Aadhya");
		 */

		lUtils.removeMaximumValues(lStr, 1);
		for (String s : lStr) {
			System.out.println(s + "   ");
		}

		lUtils.insertSorted(lLNumbers1, 22);
		for (Integer k : lLNumbers1) {
			System.out.println(k + "   ");
		}

		lLNumbers2.clear();
		lLNumbers1.clear();
		lLNumbers1.add(1);
		lLNumbers1.add(2);
		lLNumbers1.add(3);
		lLNumbers1.add(4);
		lLNumbers2.add(1);
		lLNumbers2.add(2);
		lLNumbers2.add(3);
		if (lUtils.containsSubsequence(lLNumbers1, lLNumbers2)) {
			System.out.println("LinkedList2 is subsequence of LinkedList 1" + "   ");
		}

	}
}
