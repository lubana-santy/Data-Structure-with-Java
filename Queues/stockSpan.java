import java.util.Scanner;

public class Solution {
public static int[] stockSpan(int[] price) {
		// Write your code here
        Queue<Integer> days = new Queue<Integer>();
        days.enqueue(1);
        for(int i = 1; i < price.length; i++)
        {
            int k = i;
            int count = 1;
            while(k > 0)
            {
                if(price[k-1] >= price[i])
                {
                    //count++;
                    break;
                }
                count++;
                k--;
            }
            days.enqueue(count);
        }
        int[] arr = new int[days.size()];
        int i = 0;
        while(!days.isEmpty())
        {
            arr[i] = days.dequeue();
            i++;
        }
        return arr;
	}
}
class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}
class Queue<T>{
    int count = 0;
    Node<T> head;
    Node<T> tail;
    public Queue(){
        this.head = null;
        this.tail = null;
    }
    public void enqueue(int data)
    {
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
    public boolean isEmpty(){
        return count == 0;
    }
    public int size(){
        return count;
    }
    public T dequeue(){
        if(!isEmpty())
        {
            T temp = head.data;
            head = head.next;
            count-=1;
            return temp;
        }
        return null;
    }
}
public class Main {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++) {
			input[i] = s.nextInt();
		}
		int output[] = Solution.stockSpan(input);
		for(int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
	}
}