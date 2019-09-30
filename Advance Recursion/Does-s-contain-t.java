import java.util.Scanner;

public class Solution 
{
	public static boolean checkSequence(String a, String b) 
    {
        if(b.length()==0)
        {
            return true;
        }
        if(a.length()==0)
        {
            return false;
        }
        if(a.charAt(0) == b.charAt(0))
        {
            return checkSequence(a.substring(1),b.substring(1));
        }
        else
        {
            return checkSequence(a.substring(1),b);
        }
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String large = s.nextLine();
		String small = s.nextLine();

		System.out.println(Solution.checkSequence(large, small));
	}
}