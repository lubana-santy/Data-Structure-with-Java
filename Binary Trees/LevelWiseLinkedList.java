
import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
public class Solution 
{
    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) 
    {
        ArrayList<Node<BinaryTreeNode<Integer>>> al=new ArrayList<Node<BinaryTreeNode<Integer>>>();
        QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<BinaryTreeNode<Integer>>();
        q.enqueue(root);
        while(!q.isEmpty())
        {
            Node<BinaryTreeNode<Integer>> st=null;
            Node<BinaryTreeNode<Integer>> ptr=null;
            int a=q.size();
            for(int i=0;i<a;i++)
            {
                try
                {
                    root=q.dequeue();
                }
                catch(Exception e){}
                Node<BinaryTreeNode<Integer>> temp=new Node<BinaryTreeNode<Integer>>(root);
                if(st==null)
                {
                    st=temp;
                    ptr=st;
                }
                else
                {
                    ptr.next=temp;
                    ptr=ptr.next;
                }
                if(root.left!=null)
                {
                    q.enqueue(root.left);
                }
                if(root.right!=null)
                {
                    q.enqueue(root.right);
                }
            }
            al.add(st);
        }
        return al;
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
		ArrayList<Node<BinaryTreeNode<Integer>>> output = Solution.LLForEachLevel(root);
		for(Node<BinaryTreeNode<Integer>> head : output){
			Node<BinaryTreeNode<Integer>> temp = head;
			while(temp != null){
				System.out.print(temp.data.data + " ") ;
				temp = temp.next;
			}
			System.out.println();
		}
	}

}
