package Q2_01_Remove_Dups;

import CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class QuestionA2 {
	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next; // get the previous node to point to node after deleted node n, thus deleting n
			} else {
				set.add(n.data);
				previous = n; // update previous node pointer, without update next pointer of previous before updating previous node pointer
			}
			n = n.next;
		}
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
}
