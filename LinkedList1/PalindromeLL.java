import java.util.Scanner;

public class Solution 
{
	public static boolean isPalindrome_2(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> start=head;	
        int data = start.data;
		LinkedListNode<Integer> st = null;
		LinkedListNode<Integer> tail = null;
		while (start.next!=null)
        {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (st == null)
            {
				st = newNode;
				tail = newNode;
			} 
            else
            {
				tail.next = newNode;
				tail = newNode;
			}
            start=start.next;
			data = start.data;
        }
        LinkedListNode<Integer> reverse = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> previous = null;
        int i=0;
        while(current!=null)
        {
            LinkedListNode<Integer> temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            i+=1;
        }
        reverse = previous;
        int j=0;
        while(j < i/2)
        {
            
            if(st.data!=reverse.data)
                return false;
            st = st.next;
            reverse = reverse.next;
            j++;
        }        
        return true;
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
		System.out.print(Solution.isPalindrome_2(input()));
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
