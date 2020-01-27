import java.util.Scanner;


class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

public class BinarySearchTree 
{

    public static BinaryTreeNode<Integer> root;
    public static BinaryTreeNode<Integer> insertData(int data)
    {
        root=insertData(data,root);
        return root;
    }
    public static BinaryTreeNode<Integer> insertData(int data,BinaryTreeNode<Integer> root)
    {
        if(root==null){
            BinaryTreeNode<Integer> node=new BinaryTreeNode<Integer>(data);
            return node;
        }
        else if(data>root.data){
            root.right=insertData(data,root.right);
        }
        else{
            root.left=insertData(data,root.left);
        }
        return root;
    }
    
    
    
    
    public static BinaryTreeNode<Integer> deleteData(int data)
    {
        root=deleteData(data,root);
        return root;
    }
    public static BinaryTreeNode<Integer> deleteData(int data,BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return null;
        else if(root.data==data)
        {
            if(root.left==null&&root.right==null)
                return null;
            else if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else
            {
                BinaryTreeNode<Integer> temp=root.right;
                BinaryTreeNode<Integer> prev=null;
                while(temp.left!=null)
                {
                    prev=temp;
                    temp=temp.left;
                }
                root.data=temp.data;
                if(prev==null)
                    root.right=temp.right;
                else 
                    prev.left=null;
            }
        }
        else if(root.data>data)
            root.left=deleteData(data,root.left);
        else if(root.data<data)
            root.right=deleteData(data,root.right);
        return root;
    }
    
    
    
    
    public static boolean search(int data)
    {
        return search(data,root);
    }
    public static boolean search(int data,BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return false;
        else if(root.data==data)
            return true;
        else if(root.data>data)
            return search(data,root.left);
        else if(root.data<data)
            return search(data,root.right);
        else
            return false;
    }
    
    
    
    
    public static void printTree()
    {
        printTree(root);
    }
    public static void printTree(BinaryTreeNode<Integer> root)
    {
        if(root==null)
            return;
        System.out.print(root.data+":");
        if(root.left!=null)
            System.out.print("L:"+root.left.data+",");
        if(root.right!=null)
            System.out.println("R:"+root.right.data);
        else
             System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
}
public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
	}
}
