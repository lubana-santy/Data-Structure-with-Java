import java.util.Scanner;

public class Solution {
	public static void printReverseRecursive(LinkedListNode<Integer> root) {
        /*LinkedListNode<Integer> current = root;
        LinkedListNode<Integer> previous = null;
        
        while(current!=null)
        {
            LinkedListNode<Integer>temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        root = previous;
        
    while(root!=null)
    {
        System.out.print(root.data+" ");
        root=root.next;
    }*/
        if(root == null)
            return;
        printReverseRecursive(root.next);
        System.out.print(root.data+" ");
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
	private static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		Solution.printReverseRecursive(input());
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