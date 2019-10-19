import java.util.Scanner;

public class Solution {
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
		LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> temp1 = head;
        int c_i = 0, c_j = 0, d_i = 0, d_j = 0;
        if(i > j)
        {
            while(temp1.next != null || temp.next != null)
        {
            if(c_i == i)
            {
                temp1.data = temp.data;
                temp.data = c_j;
                break;
            }
            if(c_j == j)
            {
                c_j = temp1.data;
            }
            if(c_i < i)
            {
                temp = temp.next;
                c_i += 1;
            }
            if(c_j < j)
            {
                temp1 = temp1.next;
                c_j += 1;
    
            }
      }
        return head;
    
        }
        
        while(temp1.next != null || temp.next != null)
        {
            if(c_i == i)
            {
                c_i = temp.data;
            }
            if(c_j == j)
            {
                temp.data = temp1.data;
                temp1.data = c_i;
                break;
            }
            if(c_i < i)
            {
                temp = temp.next;
                c_i += 1;
            }
            if(c_j < j)
            {
                temp1 = temp1.next;
                c_j += 1;
    
            }
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
public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Solution.swap_nodes(input(), s.nextInt(), s.nextInt()));
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
