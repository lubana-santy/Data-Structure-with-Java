import java.util.Scanner;


public class Solution {

	public static void reverseQueue(Queue<Integer> q) {

        if(q.size() <= 1)
        {
            return;
        }
        int data = q.dequeue();
        reverseQueue(q);
        q.enqueue(data);
	}
}


class Queue<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() {
		if(size == 0){
			return null;
		}
		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue(){
		if(head == null){
			return null;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

public class Main {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int size = s.nextInt();
		Queue<Integer> input = new Queue<Integer>();
		for(int i = 0; i < size; i++) {
			input.enqueue(s.nextInt());
		}
		Solution.reverseQueue(input);
		while(!input.isEmpty()) {
			System.out.print(input.dequeue() + " ");
		}
	}
}