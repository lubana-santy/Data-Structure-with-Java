import java.util.Scanner;

public class Solution {
public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k)
    {
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;
        LinkedListNode<Integer> prev = null;
        int count=0;
        while(count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next != null)
        {
            head.next = kReverse(next,k);
        }
        return prev;
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
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Solution.kReverse(input(), s.nextInt()));
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.getData() + " ");
			head = head.next;
		}
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

}

