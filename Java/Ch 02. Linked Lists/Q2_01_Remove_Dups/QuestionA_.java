package Q2_01_Remove_Dups;

import CtCILibrary.LinkedListNode;

import java.util.HashSet;

public class QuestionA_ {
	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<>();
		LinkedListNode it = new LinkedListNode(-1);
		it.next = n;
		while (it != null && it.next != null) {
			while (it != null && it.next != null && set.contains(it.next.data)) {
				it.next = it.next.next;
			}
			if (it != null && it.next != null) {
				set.add(it.next.data);
			}
			it = it.next;
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
