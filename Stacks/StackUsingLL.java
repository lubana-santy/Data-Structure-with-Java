import java.util.Scanner;

class Node<T> {
	T data;
	Node next;

	public Node(T data) {
		this.data = data;
	}
}
public class Stack<T> {
	int count = 0;
    Node<T> top;
	public Stack() {
        this.top = null;
	}
	
	public int size() {
        return count;
	}
	
	public void push(T data) {
        Node<T> temp = new Node(data);
        // if(temp == null)
        //     return;
        //temp.data = data;
        temp.next = top;
        top = temp;
        count+=1;
	}
	
	public boolean isEmpty() {
        return count == 0;
	}
	
	public T pop() throws StackEmptyException {
        if(top == null)
        {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        T data = top.data;
        top = top.next;
        count--;
        return data;
	}
	
	public T top() throws StackEmptyException {
        if(!isEmpty())
            return top.data;
        else
        {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
	}
}
class StackEmptyException extends Exception{
    private static long serialVersionUID = 1L;
}

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Stack<Integer> st = new Stack<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.push(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.pop());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.top());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println(st.size());
			}
			else if(choice == 5) {
				System.out.println(st.isEmpty());
			}
			choice = s.nextInt();
		}
	}
}
