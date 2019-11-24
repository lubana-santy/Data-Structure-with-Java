import java.util.Scanner;
import java.util.Stack;

import java.util.Stack;

public class Solution {

	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
		if(s1.size() <= 1)
            return;
        int lastElement = s1.pop();
        reverseStack(s1,s2);
        while(!s1.isEmpty())
        {
            int temp = s1.pop();
            s2.push(temp);
        }
        s1.push(lastElement);
        while(!s2.isEmpty())
        {
            int temp = s2.pop();
            s1.push(temp);
        }
    
	}
}
public class Main {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = s.nextInt();
		Stack<Integer> input = new Stack<Integer>();
		for(int i = 0; i < size; i++) {
			input.push(s.nextInt());
		}
		Stack<Integer> extra = new Stack<Integer>();
		Solution.reverseStack(input, extra);
		while(!input.isEmpty()) {
			System.out.print(input.pop() + " ");
		}
	}
}