import java.util.Scanner;

public class Solution {

	public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> head = new LinkedListNode(0);
        LinkedListNode<Integer> tail = head;
        while(true)
        {
            if(head1 == null)
            {
                tail.next = head2;
                break;
            }
            if(head2 == null)
            {
                tail.next = head1;
                break;
            }
            if(head1.data <= head2.data)
            {
                tail.next = head1;
                head1 = head1.next;
            }
            else
            {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return head.next;
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
		LinkedListNode<Integer> head1 = takeInput();
		LinkedListNode<Integer> head2 = takeInput();
		LinkedListNode<Integer> head3 = Solution.mergeTwoList(head1, head2);
		print(head3);
	}
}