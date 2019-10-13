import java.util.Scanner;

public class Solution {
    static int s = 0;
	public static LinkedListNode<Integer> deleteIthNodeRec(LinkedListNode<Integer> head, int i){
        LinkedListNode<Integer> start = head;
        if(head == null)
        {
            return head;
        }
        if(s == i)
        {
            start.next = start.next.next;
            return head;
        }
        s+=1;
        start = start.next;
        return deleteIthNodeRec(start, i);
        
	}
}

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = takeInput();
		int pos = s.nextInt();
		head = Solution.deleteIthNodeRec(head, pos);
		print(head);
	}
}