import java.util.Scanner;

import java.util.*;
public class Solution {

    public static Stack<Character> brackets = new Stack<Character>();
	public static boolean checkBalanced(String exp) {
		// Write your code here
        for(int i = 0; i < exp.length(); i++)
        {
            if((exp.charAt(i)=='{')||(exp.charAt(i)=='[')||(exp.charAt(i)=='('))
            {
                brackets.push(exp.charAt(i));
            }
            else if((exp.charAt(i)=='}')||(exp.charAt(i)==']')||(exp.charAt(i)==')'))
            {
                if(brackets.isEmpty())
                    return false;
                if(brackets.peek()==exp.charAt(i))
                    return true;
                else
                    brackets.pop();
                
            }
        }
        if(brackets.isEmpty())
            return true;
        else
            return false;
	}
}
public class Main {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(Solution.checkBalanced(input));
	}
}