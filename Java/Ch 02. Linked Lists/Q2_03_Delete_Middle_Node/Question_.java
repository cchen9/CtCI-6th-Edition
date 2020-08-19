package Q2_03_Delete_Middle_Node;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Question_ {

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}

}
