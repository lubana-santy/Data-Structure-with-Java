
import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;


public class Solution {

	public static void printLevelWise(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>> q1 = new QueueUsingLL<>();
        QueueUsingLL<BinaryTreeNode<Integer>> q2 = new QueueUsingLL<>();
        q1.enqueue(root);
        while(!q1.isEmpty())
        {
            BinaryTreeNode<Integer> front = null;
            try{
                front = q1.dequeue();
            }
            catch(QueueEmptyException e)
            {
                
            }
            System.out.print(front.data + " ");
            if(front.left != null)
            {
                q2.enqueue(front.left);
            }
            if(front.right != null)
            {
                q2.enqueue(front.right);
            }
            if(q1.isEmpty())
            {
                QueueUsingLL<BinaryTreeNode<Integer>> temp = q2;
                q2 = q1;
                q1 = temp;
                System.out.println();
            }
            
        }


	}



}


class QueueEmptyException extends Exception {
}

class Node<T> {
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}
}

class QueueUsingLL<T> {


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

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
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

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
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

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

public class Main {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		Solution.printLevelWise(root);
	}
}