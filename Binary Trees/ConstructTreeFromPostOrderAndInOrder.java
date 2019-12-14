
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post,int[] in)
    {
        // Write your code here
        return helper(post,in,0,post.length-1,0,in.length-1);
    }
    public static BinaryTreeNode<Integer> helper(int[] post,int[] in,int postS,int postE,int inS,int inE)
    {
        if(inS>inE)
            return null;
        int rootdata=post[postE];
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
        int i=inS;
        while(i<=inE){
            if(in[i]==rootdata)
                break;
            i++;
        }
        int lis=inS;
        int lie=i-1;
        int ris=i+1;
        int rie=inE;

        int lps=postS;
        int rpe=postE-1;
        int ll=lie-lis+1;
        int lpe=lps+ll-1;
        int rps=lpe+1;

        root.left=helper(post,in,lps,lpe,lis,lie);
        root.right=helper(post,in,rps,rpe,ris,rie);
        return root;
    }
}

class QueueEmptyException extends Exception {
}


class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
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


public class Main {
	static Scanner s = new Scanner(System.in);

	public static void printLevelWiseAtDiffLine(BinaryTreeNode<Integer> root){
		QueueUsingLL<BinaryTreeNode<Integer>>  primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>>  secondary = new QueueUsingLL<>();

		primary.enqueue(root);

		while(!primary.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if(current.left != null){
				secondary.enqueue(current.left);
			}
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				QueueUsingLL<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}

	
	public static void main(String[] args) {
		
		int size = s.nextInt();
		int[] pre = new int[size];
		for(int i = 0; i < size; i++){
			pre[i] = s.nextInt();
		}
		int in[] = new int[size];
		for(int i = 0; i < size; i++){
			in[i] = s.nextInt();
		}
		BinaryTreeNode<Integer> root = Solution.getTreeFromPostorderAndInorder(pre, in);
		printLevelWiseAtDiffLine(root);
		
	}
}