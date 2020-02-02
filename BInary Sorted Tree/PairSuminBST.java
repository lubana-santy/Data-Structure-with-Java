import java.util.*;

class QueueEmptyException extends Exception {
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

public class Solution {

    public static void toArray(BinaryTreeNode<Integer> root,ArrayList<Integer> arr)
    {
        if(root == null)
            return;
        arr.add(root.data);
        toArray(root.left,arr);
        toArray(root.right,arr);
    }
	public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
		if(root == null)
            return;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        toArray(root,arr);
        Collections.sort(arr);
        int i = 0;
        int j = arr.size() - 1;
        while(i < j)
        {
            if(arr.get(i) + arr.get(j) == sum)
            {
                System.out.println(arr.get(i) + " " + arr.get(j));
                i++;
                j--;
            }
            else if(arr.get(i) + arr.get(j) > sum)
                j--;
            else
                i++;
        }

	}
}

public class Runner {
	static Scanner s = new Scanner(System.in);
 static int sum ;
	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new Queue<BinaryTreeNode<Integer>>();
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
    sum = s.nextInt();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();

		Solution.nodesSumToS(root, sum);
	}
}
