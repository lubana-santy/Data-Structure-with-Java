import java.util.Scanner;

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}
public class Queue<T> {
    int count = 0;
    Node<T> head;
    Node<T> tail;
	public Queue() {
        this.head = null;
        this.tail = null;
	}

	public void enqueue(T data) {
        Node<T> temp = new Node(data);
        count+=1;
        if(this.tail == null)
        {
            this.head = temp;
            this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
	}

	public int size() {
        return count;
	}

	public boolean isEmpty() {
        return count == 0;
	}

	public T dequeue() throws QueueEmptyException {
        if(!isEmpty())
        {
            T data = head.data;
            head = head.next;
            count--;
            return data;
        }
        else
        {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
	}

	public T front() throws QueueEmptyException {
        if(!isEmpty())
        {
            return head.data;
        }
        else
        {
            QueueEmptyException e = new QueueEmptyException();
            throw e;
        }
	}
}
class QueueEmptyException extends Exception{
    private static long serialVersionUID = 1L;
}

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Queue<Integer> st = new Queue<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.enqueue(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.dequeue());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.front());
				} catch (QueueEmptyException e) {
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
