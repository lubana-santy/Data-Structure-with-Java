import java.util.Scanner;

public class Solution {
	public static int printMiddel(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        int i=1;
        while(temp.next != null)
        {
            temp = temp.next;
            i+=1;
        }
        int num = 0;
        if(i%2 == 0)
        for(int j=0;j<i/2;j++)
        {
            num = head.data;
            head = head.next;
        }
        else
           for(int j=0;j<=i/2;j++)
        {
            num = head.data;
            head = head.next;
        } 
        return num;
	}
}

public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(Solution.printMiddel(input()) + "");
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
