import java.util.Scanner;

public class Solution {
    static int s = 0;
	public static int indexOfNRec(LinkedListNode<Integer> head, int n) {
		if(head == null)
        {
            return -(s+1);
        }
        if(head.data == n)
        {
            if(s == 0)
                return 0;
            return 0;
        }
        s+=1;
        head = head.next;
        return (1 + indexOfNRec(head, n));
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
	

	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = takeInput();
		int n = s.nextInt();
		System.out.println(Solution.indexOfNRec(head, n));
	}
}