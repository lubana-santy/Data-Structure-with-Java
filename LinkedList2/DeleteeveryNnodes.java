import java.util.Scanner;

public class solution {
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        LinkedListNode<Integer> temp = head;
        int c_m = 0, c_n = 0;
        if(M == 0)
        {
            return null;
        }
        M -= 1;
        while(temp.next != null)
        {
            
            if(c_m == M && c_n < N)
            {
                temp.next = temp.next.next;
                c_n += 1;
                if(c_n == N)
                {
                    c_n = 0;
                    c_m = -1;
                }
            }
            else
            {
                c_m += 1;
                temp = temp.next;
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
public class Main {


	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(solution.skipMdeleteN(input(), s.nextInt(), s.nextInt()));
	}

	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.next;
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
