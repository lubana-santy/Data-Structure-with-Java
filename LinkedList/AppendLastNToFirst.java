import java.util.Scanner;

public class Solution {
	public static LinkedListNode<Integer> append(LinkedListNode<Integer> root, int n) {
        LinkedListNode<Integer> temp1 = root;
        LinkedListNode<Integer> temp2 = root;
        int i = -n;
        while(temp1.next != null)
        {
            if(i>=0)
                temp2 = temp2.next;
            temp1 = temp1.next;
            i++;
        }
        temp1.next = root;
        root = temp2.next;
        temp2.next = null;
        
        return root;
    }
}

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Solution.append(input(), s.nextInt()));
	}

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();
		
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data!=-1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}

}