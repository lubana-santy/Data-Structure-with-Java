import java.util.Scanner;

public class Solution {
	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> odd = null;
        LinkedListNode<Integer> oTail = null;
        LinkedListNode<Integer> even = null;
        LinkedListNode<Integer> eTail = null;
        int flag = 0, oFlag = 0;
        if(temp.next == null)
        {
            return head;
        }
        while(temp != null)
        {
            if(temp.data%2 == 0)
            {
                flag = 1;
                if(even == null)
                {
                    even = temp;
                    eTail = temp;
                }
                else
                {
                    eTail.next = temp;
                    eTail = eTail.next;
                }
            }
            else
            {
                oFlag = 1;
                if(odd == null)
                {
                    odd = temp;
                    oTail = temp;
                }
                else
                {
                    oTail.next = temp;
                    oTail = oTail.next;
                }
            }
            temp = temp.next;
        }
        if(flag == 0)
        {
            oTail.next = null;
            return odd;
        }
        else if(oFlag == 0)
        {
            eTail.next = null;
            return even;
        }
        oTail.next = even;
        eTail.next = null;
        return odd;
	}
}

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data=data;
		this.next = null;
	}
}

public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Solution.sortEvenOdd(input()));
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
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
