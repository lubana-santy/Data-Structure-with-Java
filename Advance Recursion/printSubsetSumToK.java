import java.util.Scanner;
import java.util.*;
public class solution {
    // The vector v stores current subset.  
static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v,  
                        int sum)  
{  
    
    if (sum == 0) { 
		for (int i=v.size()-1;i>=0;i--) 
			System.out.print( v.get(i) + " "); 
		System.out.println(); 
		return; 
	} 
  
    // If no remaining elements,  
    if (n == 0)  
        return;  
  
    // We consider two cases for every element.  
    // a) We do not include last element.  
    // b) We include last element in current subset.  
    printAllSubsetsRec(arr, n - 1, v, sum);  
    Vector<Integer> v1=new Vector<Integer>(v); 
    v1.add(arr[n - 1]);  
    printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1]);  
}  
  
  
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
		    Vector<Integer> v= new Vector<Integer>();
            int n = input.length;
    printAllSubsetsRec(input, n, v, k);
	}
}
public class runner {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		solution.printSubsetsSumTok(input, k);
	}
}
