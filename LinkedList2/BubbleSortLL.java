import java.util.Scanner;

public class Solution {
	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head )
	{
		LinkedListNode<Integer> start = head;
        LinkedListNode<Integer> bubble = start.next;
        while(start.next != null)
        {
            while(bubble != null)
            {
                if(start.data >= bubble.data)
                {
                    int temp = start.data;
                    start.data = bubble.data;
                    bubble.data = temp;
                }
                bubble = bubble.next;
            }
            start = start.next;
            bubble = start.next;
        }
        return head;
	}



}

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}

public class Runner {
	private static Scanner s= new Scanner(System.in);
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		print(Solution.bubbleSort(input()));
	}
}
