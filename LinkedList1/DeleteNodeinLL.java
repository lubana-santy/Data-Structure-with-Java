import java.util.Scanner;

public class Solution {

	public static LinkedListNode<Integer> deleteIthNode(LinkedListNode<Integer> head, int i){
		
        LinkedListNode<Integer> newNode = head;
        LinkedListNode<Integer> count = head;
        if(i == 0)
        {
            head = head.next;
            return head;
        }
        int c = 0;
        while(count!=null)
        {
            count = count.next;
            c++;
        }
        if(i < c)
        {
        int p=0;
       // LinkedListNode<Integer> temp = null;
        while(p < i-1)
        {
            newNode = newNode.next;
            p++;
         }
        // if((newNode == null)&&(newNode.next == null))
        //     return head;
        LinkedListNode<Integer> temp = newNode.next.next;
        newNode.next = temp;
	    return head;
        }
        return head;
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
		head = Solution.deleteIthNode(head, pos);
		print(head);
	}
}